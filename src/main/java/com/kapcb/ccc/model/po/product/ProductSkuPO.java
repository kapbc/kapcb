package com.kapcb.ccc.model.po.product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

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

    /**
     * sku id
     */
    private Long skuId;

    /**
     * 产品id
     */
    private Long productId;

    /**
     * sku编码
     */
    private String skuCode;

    /**
     * 商品库存
     */
    private Integer stock;

    /**
     * 库存预警值
     */
    private Integer lowStockWarning;

    /**
     * 商品展示图片
     */
    private String thumbImg;

    /**
     * 商品销量
     */
    private Integer sale;

    /**
     * 商品促销价格
     */
    private BigDecimal promotionPrice;

    /**
     * 锁定库存
     */
    private Integer lockStock;

    /**
     * 商品销售属性, json
     */
    private String spuData;
}
