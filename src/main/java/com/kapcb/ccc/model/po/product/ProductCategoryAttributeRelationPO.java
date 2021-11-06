package com.kapcb.ccc.model.po.product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * <a>Title: ProductCategoryAttributeRelationPO </a>
 * <a>Author: Kapcb <a>
 * <a>Description: ProductCategoryAttributeRelationPO <a>
 *
 * @author Kapcb
 * @version 1.0.0
 * @date 2021/11/5 22:25
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductCategoryAttributeRelationPO implements Serializable {

    private static final long serialVersionUID = 8291746970491856411L;

    /**
     * 商品类目属性关系主键id
     */
    private Long relationId;

    /**
     * 商品类目id
     */
    private Integer categoryId;

    /**
     * 商品属性id
     */
    private Long attributeId;

    /**
     * 创建用户id
     */
    private Long createBy;

    /**
     * 创建时间
     */
    private Date createDate;

    /**
     * 最后更新用户id
     */
    private Long lastUpdateBy;

    /**
     * 最后更新时间
     */
    private Date lastUpdateDate;

    /**
     * 逻辑删除: 0->未删除; 1->删除;
     */
    private Integer deleteStatus;

    /**
     * 乐观锁
     */
    private Integer version;
}
