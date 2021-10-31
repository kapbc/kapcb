package com.kapcb.ccc.struts;

import com.kapcb.ccc.model.Test;
import com.kapcb.ccc.model.po.DictionaryPO;
import com.kapcb.ccc.model.vo.LocationVO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * <a>Title: UserConvertMapper </a>
 * <a>Author: Kapcb <a>
 * <a>Description: UserConvertMapper <a>
 *
 * @author Kapcb
 * @version 1.0.0
 * @date 2021/10/30 18:52
 */
@Mapper(componentModel = "spring")
public interface DictionaryConvertMapper {

    DictionaryConvertMapper instance = Mappers.getMapper(DictionaryConvertMapper.class);

    /**
     * convert DictionaryPO to LocationVO
     *
     * @param dictionaryPO DictionaryPO
     * @return LocationVO
     */
    @Mapping(target = "children", expression = "java(new java.util.ArrayList())")
    @Mapping(source = "parentId", target = "parentId")
    @Mapping(source = "dictionaryId", target = "id")
    @Mapping(source = "dictionaryValueEn", target = "locationEn")
    @Mapping(source = "dictionaryValueZh", target = "locationZh")
    LocationVO convertLocation(DictionaryPO dictionaryPO);

    DictionaryPO convertCountry();

    @Mapping(source = "content", target = "content", conditionExpression = "java(test.getCondition() == true)")
    Test convertTest(Test test);
}
