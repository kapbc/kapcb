package com.kapcb.ccc.model.po.product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

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

    private Long categoryAttributeRelationId;

    private Integer categoryId;

    private Long attributeId;
}
