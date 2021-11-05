package com.kapcb.ccc.model.po.product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

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
     * 品牌名称
     */
    private String brandName;

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
    private Integer lowStockWarning;

    /**
     * 单位
     */
    private String unit;

    /**
     * 单位code
     */
    private String unitCode;

    /**
     * 重量
     */
    private BigDecimal weight;

    /**
     * 是否为预告商品: 0->非预告商品; 1->预告商品;
     */
    private Integer previewStatus;

    /**
     * 产品服务: 0->退换无忧; 1->7天无理由退换; 2->商家包邮; 3->;
     */
    private Integer serviceIds;

    /**
     * 商品关键字
     */
    private String productKeywords;

    /**
     * 商品备注信息
     */
    private String productRemark;

    /**
     * 购买商品成长积分
     */
    private Integer presentGrowth;

    /**
     * 购买商品赠送积分
     */
    private Integer presentPoint;

    /**
     * 购买商品限制使用积分数量
     */
    private Integer usePointLimit;

    /**
     * 乐观锁
     */
    private Integer version;

    /**
     * 创建用户
     */
    private Long createBy;

    /**
     * 创建时间
     */
    private Date createDate;

    /**
     * 最后更新用户
     */
    private Long lastUpdateBy;

    /**
     * 最后更新时间
     */
    private Date lastUpdateDate;

    /**
     * 商品详情标题
     */
    private String detailTitle;

    /**
     * 是否含有图片等附件: 0->没有附件; 1->有附件;
     */
    private Integer attachmentStatus;

    /**
     * 促销开始时间
     */
    private Date promotionStartTime;

    /**
     * 促销结束时间
     */
    private Date promotionEndTime;

    /**
     * 促销限购数量
     */
    private Integer promotionPurchaseNumber;

    /**
     * 促销类型: 0->没有促销; 1->使用促销价格; 2->使用会员价; 3->阶梯价格; 4->使用满减价格; 5->限时购买; 6->折扣价;
     */
    private Integer promotionType;

    /**
     * 商品l3类目
     */
    private Integer categoryL3;

    /**
     * 商品详细描述
     */
    private String detailDescription;

    /**
     * 商品详情页面布局类型
     */
    private Integer layoutType;
}
