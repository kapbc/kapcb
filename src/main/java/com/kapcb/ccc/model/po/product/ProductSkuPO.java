package com.kapcb.ccc.model.po.product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * <a>Title: ProductSkuPO </a>
 * <a>Author: Kapcb <a>
 * <a>Description: ProductSkuPO <a>
 *
 * @author Kapcb
 * @version 1.0.0
 * @date 2021/11/5 22:48
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductSkuPO implements Serializable {

    private static final long serialVersionUID = -3996014207290594222L;

    private Long skuId;

    private Long productId;

    private String skuSerialNumber;

    private Integer stock;

    private Integer lowStockWarning;

//    private String
}
