package com.kapcb.ccc.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kapcb.ccc.enums.LongPool;
import com.kapcb.ccc.enums.StringPool;
import com.kapcb.ccc.lisenter.CountryAnalyzeListener;
import com.kapcb.ccc.mapper.DictionaryMapper;
import com.kapcb.ccc.model.initial.CountryCodeAnalyzeDTO;
import com.kapcb.ccc.model.po.DictionaryPO;
import com.kapcb.ccc.service.IDictionaryService;
import com.kapcb.ccc.utils.InitialDataAnalyzeUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Service;

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
    private static List<String> cityAnalyze;
    private static List<String> provinceAnalyze;

    @PostConstruct
    void init() {
        countryCodeAnalyzeDTOS = InitialDataAnalyzeUtil.analyzeExcel("doc/country_code.xls", CountryCodeAnalyzeDTO.class, new CountryAnalyzeListener()).getResult();
        cityAnalyze = InitialDataAnalyzeUtil.analyzeXml("xml/province.xml");
        provinceAnalyze = InitialDataAnalyzeUtil.analyzeXml("xml/city.xml");
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
    public Boolean analyzeCity() {
        if (CollectionUtils.isNotEmpty(cityAnalyze)) {
            Date currentDate = new Date();
//            cityAnalyze.parallelStream().map(city->DictionaryPO.builder().)
        }
        return null;
    }

}
