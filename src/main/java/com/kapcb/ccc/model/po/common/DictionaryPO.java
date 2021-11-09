package com.kapcb.ccc.model.po.common;

import cn.org.atool.fluent.mybatis.annotation.FluentMybatis;
import cn.org.atool.fluent.mybatis.annotation.LogicDelete;
import cn.org.atool.fluent.mybatis.annotation.TableField;
import cn.org.atool.fluent.mybatis.annotation.TableId;
import cn.org.atool.fluent.mybatis.annotation.Version;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * <a>Title: DictionaryPO </a>
 * <a>Author: Kapcb <a>
 * <a>Description:  <a>
 *
 * @author Kapcb
 * @version 1.0.0
 * @date 2021/8/1 15:17
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@FluentMybatis(schema = "common_grp", table = "dictionary")
public class DictionaryPO implements Serializable {

    private static final long serialVersionUID = -3216105866722192952L;

    @TableId(value = "dictionary_id")
    private Integer dictionaryId;

    @TableField(value = "dictionary_code")
    private String dictionaryCode;

    @TableField(value = "dictionary_value_en")
    private String dictionaryValueEn;

    @TableField(value = "dictionary_value_zh")
    private String dictionaryValueZh;

    @TableField(value = "dictionary_description")
    private String dictionaryDescription;

    @TableField(value = "dictionary_group")
    private String dictionaryGroup;

    @TableField(value = "dictionary_remark")
    private String dictionaryRemark;

    @TableField(value = "dictionary_num")
    private Integer dictionaryNum;

    @TableField(value = "create_date")
    private Date createDate;

    @TableField(value = "create_by")
    private Long createBy;

    @TableField(value = "last_update_date")
    private Date lastUpdateDate;

    @TableField(value = "last_update_by")
    private Long lastUpdateBy;

    @LogicDelete
    @TableField(value = "delete_flag")
    private Boolean deleteFlag;

    @Version
    @TableField(value = "version")
    private Integer version;

    @TableField(value = "parent_id")
    private Integer parentId;
}
