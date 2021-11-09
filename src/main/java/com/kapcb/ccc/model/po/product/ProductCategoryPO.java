package com.kapcb.ccc.model.po.product;

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
 * <a>Title: ProductCategoryPO </a>
 * <a>Author: Kapcb <a>
 * <a>Description:  <a>
 *
 * @author Kapcb
 * @version 1.0.0
 * @date 2021/8/1 23:39
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@FluentMybatis(schema = "product_grp", table = "product_category")
public class ProductCategoryPO implements Serializable {

    private static final long serialVersionUID = -3823181862793064458L;

    @TableId(value = "category_id")
    private Integer categoryId;

    @TableField("parent_id")
    private Integer parentId;

    @TableField("category_level")
    private Integer categoryLevel;

    @TableField("category_name")
    private String categoryName;

    @LogicDelete
    @TableField("delete_flag")
    private Boolean deleteFlag;

    @Version
    @TableField("version")
    private Integer version;

    @TableField("create_date")
    private Date createDate;

    @TableField("create_by")
    private Long createBy;

    @TableField("last_update_date")
    private Date lastUpdateDate;

    @TableField("last_update_by")
    private Long lastUpdateBy;
}
