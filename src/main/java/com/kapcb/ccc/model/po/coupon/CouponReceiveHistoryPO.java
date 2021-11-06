package com.kapcb.ccc.model.po.coupon;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * <a>Title: CouponReceiveHistoryPO </a>
 * <a>Author: Kapcb <a>
 * <a>Description: CouponReceiveHistoryPO <a>
 *
 * @author Kapcb
 * @version 1.0.0
 * @date 2021/11/6 13:06
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CouponReceiveHistoryPO implements Serializable {

    private static final long serialVersionUID = 198475807988534292L;

    /**
     * 自增主键id
     */
    private Long receiveId;

    /**
     * 优惠卷id
     */
    private Long couponId;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 用户名
     */
    private String username;

    /**
     * 优惠卷code
     */
    private String couponCode;

    /**
     * 优惠卷获取类型: 0->主动赠送; 1->自动领取
     */
    private Integer receiveType;

    /**
     * 优惠卷领取时间
     */
    private Date createDate;

    /**
     * 优惠卷使用
     */
    private Date useDate;

    /**
     * 使用状态: 0->未使用; 1->已经使用; 2->已过期;
     */
    private Integer useStatus;

    /**
     * 订单id
     */
    private Long orderId;

    /**
     * 订单编号
     */
    private String orderSerialNumber;
}
