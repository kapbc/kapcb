package com.kapcb.ccc.model.po.order;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * <a>Title: OrderItemPO </a>
 * <a>Author: Kapcb <a>
 * <a>Description: OrderItemPO <a>
 *
 * @author Kapcb
 * @version 1.0.0
 * @date 2021/11/4 22:25
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderItemPO implements Serializable {

    private static final long serialVersionUID = 2007324101654946087L;

    /**
     * 订单详情id
     */
    private Long orderItemId;

    /**
     * 订单id
     */
    private Long orderId;

    /**
     * 商品id
     */
    private Long productId;

    /**
     * 商品图片
     */
    private String productImage;

    /**
     * 商品名称
     */
    private String productName;

    /**
     * 商品品牌
     */
    private String productBrand;

    /**
     * 商品编号
     */
    private String productSerialNumber;

    /**
     * 商品价格
     */
    private BigDecimal productPrice;

    /**
     * 商品数量
     */
    private Integer productQuantity;

    /**
     * 商品SKU id
     */
    private Long skuId;

    /**
     * 商品SKU 条码
     */
    private String skuCode;

    /**
     * 商品类目l3
     */
    private Long categoryL3;

    /**
     * 商品促销名称
     */
    private String promotionName;

    /**
     * 商品促销金额
     */
    private BigDecimal promotionAmount;

    /**
     * 优惠卷金额
     */
    private BigDecimal couponAmount;

    /**
     * 积分优惠金额
     */
    private BigDecimal integrationAmount;

    /**
     * 商品最终价格
     */
    private BigDecimal realAmount;

    /**
     * 商品属性
     */
    private String productAttr;

    private Long createBy;

    private Date createDate;

    private Long lastUpdateBy;

    private Date lastUpdateDate;

    private Boolean deleteStatus;

    private Integer version;
}
