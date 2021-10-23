package com.kapcb.ccc.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kapcb.ccc.enums.LongPool;
import com.kapcb.ccc.enums.StringPool;
import com.kapcb.ccc.lisenter.CountryAnalyzeListener;
import com.kapcb.ccc.mapper.DictionaryMapper;
import com.kapcb.ccc.model.initial.CountryCodeAnalyzeDTO;
import com.kapcb.ccc.model.po.DictionaryPO;
import com.kapcb.ccc.service.IDictionaryService;
import com.kapcb.ccc.utils.InitialDataAnalyzeUtil;
import com.kapcb.ccc.utils.PinYinUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

/**
 * <a>Title: DictionaryServiceImpl </a>
 * <a>Author: Kapcb <a>
 * <a>Description: DictionaryServiceImpl <a>
 *
 * @author Kapcb
 * @version 1.0.0
 * @date 2021/10/17 20:25
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class DictionaryServiceImpl extends ServiceImpl<DictionaryMapper, DictionaryPO> implements IDictionaryService {

    private static List<CountryCodeAnalyzeDTO> countryCodeAnalyzeDTOS;
    private static List<String> provinceAnalyze;
    private static List<String> cityAnalyze;

    @PostConstruct
    void init() {
        countryCodeAnalyzeDTOS = InitialDataAnalyzeUtil.analyzeExcel("doc/country_code.xls", CountryCodeAnalyzeDTO.class, new CountryAnalyzeListener()).getResult();
        provinceAnalyze = InitialDataAnalyzeUtil.analyzeXml("xml/province.xml");
        cityAnalyze = InitialDataAnalyzeUtil.analyzeXml("xml/city.xml");
    }

    @Override
    public Boolean analyzeCountryCode() {
        if (CollectionUtils.isNotEmpty(countryCodeAnalyzeDTOS)) {
            Date currentDate = new Date();
            List<DictionaryPO> dictionaryPOList = countryCodeAnalyzeDTOS.parallelStream().map(country -> CompletableFuture.supplyAsync(() -> DictionaryPO.builder()
                    .dictionaryRemark(country.getRemark())
                    .dictionaryCode(country.getCodeTwo())
                    .dictionaryDescription(country.getDescription())
                    .dictionaryValueEn(country.getEN())
                    .dictionaryValueZh(country.getCN())
                    .createDate(currentDate)
                    .createBy(LongPool.DEFAULT_SUPER_ADMIN.value())
                    .dictionaryNum(country.getNumber())
                    .dictionaryGroup(StringPool.DICTIONARY_GROUP_COUNTRY.value()).build())).collect(Collectors.toList()).stream().map(CompletableFuture::join).collect(Collectors.toList());
            log.info("country analyze result is : {}", dictionaryPOList);
            if (CollectionUtils.isNotEmpty(dictionaryPOList)) {
                for (DictionaryPO dictionaryPO : dictionaryPOList) {
                    this.baseMapper.insert(dictionaryPO);
                }
            }

        }
        return Boolean.TRUE;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean analyzeProvince() {
        if (CollectionUtils.isNotEmpty(provinceAnalyze)) {
            Date currentDate = new Date();
            List<DictionaryPO> provinceDictionary = provinceAnalyze.parallelStream().map(province -> DictionaryPO.builder()
                    .dictionaryCode(PinYinUtil.getUpperAbbreviations(province))
                    .dictionaryGroup(StringPool.DICTIONARY_GROUP_PROVINCE.value())
                    .dictionaryValueEn(province)
                    .dictionaryValueZh(PinYinUtil.getPinYin(province))
                    .dictionaryDescription("province dictionary")
                    .createDate(currentDate)
                    .createBy(LongPool.DEFAULT_SUPER_ADMIN.value()).build()).collect(Collectors.toList());
            provinceDictionary.forEach(province -> this.baseMapper.insert(province));
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    @Override
    public Boolean analyzeCity() {
        if (CollectionUtils.isNotEmpty(cityAnalyze)) {
            Date currentDate = new Date();
            List<DictionaryPO> provinceDictionary = cityAnalyze.parallelStream().map(DictionaryServiceImpl::convert).map(city -> DictionaryPO.builder()
                    .dictionaryCode(PinYinUtil.getUpperAbbreviations(city))
                    .dictionaryGroup(StringPool.DICTIONARY_GROUP_CITY.value())
                    .dictionaryValueEn(city)
                    .dictionaryValueZh(PinYinUtil.getPinYin(city))
                    .dictionaryDescription("city dictionary")
                    .createDate(currentDate)
                    .createBy(LongPool.DEFAULT_SUPER_ADMIN.value()).build()).collect(Collectors.toList());
//            provinceDictionary.forEach(city -> this.baseMapper.insert(city));
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    private static String convert(String keyword) {
        if (StringUtils.isNotBlank(keyword)) {
            return StrUtil.sub(keyword, 0, keyword.indexOf(StringPool.ARE_BRACKET.value())).trim();
        }
        return null;
    }

    public static void main(String[] args) {
        String convert = convert("北京 (54511)");
        System.out.println("convert = " + convert);
        String pinYin = PinYinUtil.getPinYin(convert);
        System.out.println("pinYin = " + pinYin);
        String upperAbbreviations = PinYinUtil.getUpperAbbreviations(convert);
        System.out.println("upperAbbreviations = " + upperAbbreviations);
    }
}
