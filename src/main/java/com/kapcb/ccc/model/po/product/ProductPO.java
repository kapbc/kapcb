package com.kapcb.ccc.model.po.product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <a>Title: ProductPO </a>
 * <a>Author: Kapcb <a>
 * <a>Description: ProductPO <a>
 *
 * @author Kapcb
 * @version 1.0.0
 * @date 2021/11/4 22:45
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductPO implements Serializable {

    private static final long serialVersionUID = 5297863701245718658L;

    /**
     * 商品id
     */
    private Long productId;

    /**
     * 品牌id
     */
    private Long brandId;

    /**
     * 商品名称
     */
    private String productName;

    /**
     * 商品主图
     */
    private String thumbImg;

    /**
     * 商品编号
     */
    private String productSerialNumber;

    /**
     * 商品删除状: 0->未删除; 1->删除;
     */
    private Integer deleteStatus;

    /**
     * 商品上架状态: 0->未上架; 1->已上架;
     */
    private Integer publishStatus;

    /**
     * 新商品状态: 0->非新商品; 1->新商品
     */
    private Integer newProductStatus;

    /**
     * 推荐状态: 0->不推荐; 1->推荐;
     */
    private Integer recommendStatus;

    /**
     * 商品审核状态: 0->待审核; 1->审核通过; 2->审核不通过;
     */
    private Integer reviewStatus;

    /**
     * 商品排序
     */
    private Integer sort;

    /**
     * 商品价格
     */
    private BigDecimal productPrice;

    /**
     * 商品促销价格
     */
    private BigDecimal promotionPrice;

    /**
     * 商品副标题
     */
    private String subTitle;

    /**
     * 市场价格
     */
    private BigDecimal originalPrice;

    /**
     * 商品库存
     */
    private Integer stock;

    /**
     * 商品库存预警值
     */
    private Integer lowStockAlert;

    private String unit;

    private String unitCode;

    private BigDecimal weight;

    private BigDecimal weightCode;

    /**
     * 是否为预告商品: 0->非预告商品; 1->预告商品;
     */
    private Integer previewStatus;

    /**
     * 产品服务: 0->退换无忧; 1->7天无理由退换; 2->商家包邮; 3->;
     */
    private Integer serviceIds;

    private String productKeywords;

    private String productRemark;
}
