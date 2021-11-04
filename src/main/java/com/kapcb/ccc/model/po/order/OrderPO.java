package com.kapcb.ccc.model.po.order;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * <a>Title: OrderPO </a>
 * <a>Author: Kapcb <a>
 * <a>Description: OrderPO <a>
 *
 * @author Kapcb
 * @version 1.0.0
 * @date 2021/11/4 21:58
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderPO implements Serializable {

    private static final long serialVersionUID = -2520895823312769211L;

    /**
     * 订单id
     */
    private Long orderId;

    /**
     * 优惠卷id
     */
    private Long couponId;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 订单编号
     */
    private String orderSerialNumber;

    /**
     * 订单总金额
     */
    private BigDecimal totalAmount;

    /**
     * 应付金额(实际支付金额)
     */
    private BigDecimal payAmount;

    /**
     * 运费金额
     */
    private BigDecimal freightAmount;

    /**
     * 促销优惠金额
     */
    private BigDecimal promotionAmount;

    /**
     * 积分抵扣金额
     */
    private BigDecimal integrationAmount;

    /**
     * 优惠卷抵扣金额
     */
    private BigDecimal couponAmount;

    /**
     * 管理员后台调整订单使用的则扣金额
     */
    private BigDecimal discountAmount;

    /**
     * 支付方式: 0->未支付; 1->支付宝; 2->微信; 3->paypal
     */
    private Integer payMethod;

    /**
     * 订单来源: 0->PC端订单; 1->H5; 2->APP端订单;
     */
    private Integer sourceType;

    /**
     * 订单状态: 0->待付款; 1->代发货; 2->已发货; 3->已完成; 4->已关闭; 5->无效订单;
     */
    private Integer orderStatus;

    /**
     * 订单类型: 0->正常订单; 1->秒杀订单;
     */
    private Integer orderType;

    /**
     * 物流公司(配送方式)
     */
    private String deliveryCompany;

    /**
     * 物流单号
     */
    private Long deliverySerialNumber;

    /**
     * 自动确认收货天数
     */
    private Integer autoConfirmDay;

    /**
     * 订单可获得积分
     */
    private Integer integration;

    /**
     * 发票类型: 0->不开发票; 1->电子发票; 2->字纸发票;
     */
    private Integer billType;

    /**
     * 发票抬头
     */
    private String billHeader;

    /**
     * 发票内容
     */
    private String billContent;

    /**
     * 收票人电话
     */
    private String billReceiverPhone;

    /**
     * 收票人邮件地址
     */
    private String billReceiverEmail;

    /**
     * 收货人姓名
     */
    private String receiverName;

    /**
     * 收货人电话
     */
    private String receiverPhone;

    /**
     * 收货人邮编
     */
    private String receiverPostCode;

    /**
     * 省份/直辖市
     */
    private String receiverProvince;

    /**
     * 省份/直辖市 code
     */
    private String receiverProvinceCode;

    /**
     * 城市
     */
    private String receiverCity;

    /**
     * 城市 code
     */
    private String receiverCityCode;

    /**
     * 区
     */
    private String receiverRegion;

    /**
     * 区 code
     */
    private String receiverRegionCode;

    /**
     * 详细地址
     */
    private String receiverDetailAddress;

    /**
     * 订单备注
     */
    private String orderRemark;

    /**
     * 订单确认收货状态: 0->未确认; 1->已确认;
     */
    private Integer orderConfirmStatus;

    /**
     * 逻辑删除
     */
    private Boolean deleteStatus;

    /**
     * 下单时使用的积分
     */
    private Integer useIntegration;

    /**
     * 订单创建时间
     */
    private Date createDate;

    /**
     * 订单发货时间
     */
    private Date deliveryDate;

    /**
     * 订单收货时间
     */
    private Date receiveDate;

    /**
     * 订单评价时间
     */
    private Date commentDate;

    /**
     * 最后更新时间
     */
    private Date lastUpdateDate;

    /**
     * 更新用户
     */
    private Long lastUpdateBy;

    private Long createBy;

    private Integer version;
}
