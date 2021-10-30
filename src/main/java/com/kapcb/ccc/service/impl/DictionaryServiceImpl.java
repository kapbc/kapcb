package com.kapcb.ccc.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.collect.Lists;
import com.kapcb.ccc.enums.IntegerPool;
import com.kapcb.ccc.enums.LongPool;
import com.kapcb.ccc.enums.StringPool;
import com.kapcb.ccc.lisenter.CountryAnalyzeListener;
import com.kapcb.ccc.mapper.DictionaryMapper;
import com.kapcb.ccc.model.initial.CityAnalyzeDTO;
import com.kapcb.ccc.model.initial.CountryCodeAnalyzeDTO;
import com.kapcb.ccc.model.po.DictionaryPO;
import com.kapcb.ccc.model.vo.LocationVO;
import com.kapcb.ccc.service.IDictionaryService;
import com.kapcb.ccc.strtus.UserConvertMapper;
import com.kapcb.ccc.utils.InitialDataAnalyzeUtil;
import com.kapcb.ccc.utils.PinYinUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
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

    private static List<String> provinceAnalyze;
    private static List<CityAnalyzeDTO> cityAnalyze;
    private static List<CountryCodeAnalyzeDTO> countryCodeAnalyzeDTOS;

    @PostConstruct
    void init() {
        cityAnalyze = InitialDataAnalyzeUtil.analyzeCity("xml/china.xml");
        provinceAnalyze = InitialDataAnalyzeUtil.analyzeXml("xml/province.xml");
        countryCodeAnalyzeDTOS = InitialDataAnalyzeUtil.analyzeExcel("doc/country_code.xls", CountryCodeAnalyzeDTO.class, new CountryAnalyzeListener()).getResult();
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
                    .dictionaryNum(Integer.parseInt(country.getNumber()))
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
                    .dictionaryValueEn(PinYinUtil.getPinYin(province))
                    .dictionaryValueZh(province)
                    .parentId(10044)
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
            LambdaQueryWrapper<DictionaryPO> wrapper = null;
            List<DictionaryPO> dictionaryPOS = new ArrayList<>();
            for (CityAnalyzeDTO cityAnalyzeDTO : cityAnalyze) {
                List<CityAnalyzeDTO.City> cityList = cityAnalyzeDTO.getCityList();
                String province1 = cityAnalyzeDTO.getProvince();
                wrapper = Wrappers.lambdaQuery();
                wrapper.eq(DictionaryPO::getDictionaryGroup, StringPool.DICTIONARY_GROUP_PROVINCE.value())
                        .like(DictionaryPO::getDictionaryValueZh, StrUtil.sub(province1, 0, province1.length() - 1))
                        .eq(DictionaryPO::getDeleteFlag, false).last("LIMIT 1");
                DictionaryPO dictionaryPOS1 = this.baseMapper.selectOne(wrapper);
                if (Objects.nonNull(dictionaryPOS1)) {
                    for (int i = 0; i < cityList.size(); i++) {
                        CityAnalyzeDTO.City city = cityList.get(i);
                        DictionaryPO data = new DictionaryPO();
                        data.setDictionaryValueZh(city.getCity());
                        data.setDictionaryValueEn(PinYinUtil.getPinYin(StrUtil.sub(city.getCity(), 0, city.getCity().length() - 1)));
                        data.setDictionaryCode(PinYinUtil.getUpperAbbreviations(StrUtil.sub(city.getCity(), 0, city.getCity().length() - 1)));
                        data.setDictionaryNum(i + 1);
                        data.setCreateDate(currentDate);
                        data.setCreateBy(LongPool.DEFAULT_SUPER_ADMIN.value());
                        data.setDictionaryRemark(StringPool.DICTIONARY_REMARK_NON_CAPITAL_CITY.value());
                        if (city.getCapitalCity()) {
                            data.setDictionaryRemark(StringPool.DICTIONARY_REMARK_CAPITAL_CITY.value());
                        }
                        data.setParentId(dictionaryPOS1.getDictionaryId());
                        data.setDictionaryGroup(StringPool.DICTIONARY_GROUP_CITY.value());
                        dictionaryPOS.add(data);
                    }
                }
            }
            dictionaryPOS.forEach(city -> this.baseMapper.insert(city));
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    @Override
    public List<LocationVO> getAllLocation() {
        LambdaQueryWrapper<DictionaryPO> wrapper = Wrappers.lambdaQuery();
        wrapper.eq(DictionaryPO::getDeleteFlag, false)
                .in(DictionaryPO::getDictionaryGroup, Lists.newArrayList(StringPool.DICTIONARY_GROUP_CITY.value(), StringPool.DICTIONARY_GROUP_COUNTRY.value(), StringPool.DICTIONARY_GROUP_PROVINCE.value()));
        List<DictionaryPO> dictionaryPOS = this.baseMapper.selectList(wrapper);
        if (CollectionUtils.isNotEmpty(dictionaryPOS)) {
            List<LocationVO> locationList = dictionaryPOS.stream().map(dictionary -> CompletableFuture.supplyAsync(() -> UserConvertMapper.instance.conver(dictionary))).map(CompletableFuture::join).collect(Collectors.toList());

            List<LocationVO> parentNode = locationList.stream().filter(dictionary -> IntegerPool.ZERO.value().equals(dictionary.getParentId())).distinct().collect(Collectors.toList());

            if (CollectionUtils.isNotEmpty(parentNode)) {
                parentNode.forEach(parent -> parent = handler(parent, locationList));
                return parentNode;
            }
        }
        return null;
    }

    @Override
    public void trim() {
        LambdaQueryWrapper<DictionaryPO> wrapper = Wrappers.lambdaQuery();
        wrapper.eq(DictionaryPO::getDeleteFlag, false)
                .in(DictionaryPO::getDictionaryGroup, Lists.newArrayList(StringPool.DICTIONARY_GROUP_PROVINCE.value(), StringPool.DICTIONARY_GROUP_CITY.value()));
        List<DictionaryPO> dictionaryPOS = this.baseMapper.selectList(wrapper);
        dictionaryPOS.forEach(dictionary -> CompletableFuture.runAsync(() -> {
            dictionary.setDictionaryValueEn(dictionary.getDictionaryValueEn().trim());
            this.baseMapper.updateById(dictionary);
        }).join());
    }

    private LocationVO handler(LocationVO parentNode, List<LocationVO> all) {
        all.forEach(a -> {
            if (Objects.equals(parentNode.getId(), a.getParentId())) {
                parentNode.getChildren().add(handler(a, all));
            }
        });
        return parentNode;
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

        String s = DigestUtils.md5Hex("123456789");
        System.out.println("s = " + s);

    }

    private static String reverseString(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        char[] array = s.toCharArray();
        for (int left = 0, right = array.length - 1; left < right; left++, right--) {
            swap(array, left, right);
        }
        return new String(array);
    }

    private static void swap(char[] array, int left, int right) {
        char temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }
}
