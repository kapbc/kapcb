package com.kapcb.ccc.model.po.product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * <a>Title: ProductAttributeValuePO </a>
 * <a>Author: Kapcb <a>
 * <a>Description: ProductAttributeValuePO <a>
 *
 * @author Kapcb
 * @version 1.0.0
 * @date 2021/11/5 22:19
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductAttributeValuePO implements Serializable {

    private static final long serialVersionUID = 205132857083990304L;

    private Long attributeValueId;

    private Long productId;

    private Long productAttributeId;

    private String value;
}
