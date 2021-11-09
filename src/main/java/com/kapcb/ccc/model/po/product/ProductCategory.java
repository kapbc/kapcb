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
 * <a>Title: ProductCategory </a>
 * <a>Author: Kapcb <a>
 * <a>Description: ProductCategory <a>
 *
 * @author Kapcb
 * @version 1.0.0
 * @date 2021/11/6 12:21
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FluentMybatis(schema = "product_grp", table = "product_category")
public class ProductCategory implements Serializable {

    private static final long serialVersionUID = 5925355844590539865L;

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
    private Integer deleteStatus;

    /**
     * 是否显示: 0->不显示; 1->显示;
     */
    private Integer showStatus;

    /**
     * 展示图标
     */
    private String showIcon;

    /**
     * 产品数量
     */
    private Integer productCount;

    /**
     * 数量单位
     */
    private String productUnit;

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
