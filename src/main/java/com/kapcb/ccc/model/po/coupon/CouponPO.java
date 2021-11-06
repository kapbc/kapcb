package com.kapcb.ccc.model.po.coupon;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * <a>Title: CouponPO </a>
 * <a>Author: Kapcb <a>
 * <a>Description: CouponPO <a>
 *
 * @author Kapcb
 * @version 1.0.0
 * @date 2021/11/6 12:52
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CouponPO implements Serializable {

    private static final long serialVersionUID = -9081877246785512152L;

    /**
     * 自增主键id
     */
    private Long couponId;

    /**
     * 优惠卷类型: 0->全产赠送; 1->会员赠送; 2->购物赠送; 3->注册赠送;
     */
    private Integer couponType;

    /**
     * 优惠卷名称
     */
    private String couponName;

    /**
     * 使用平台: 0->无限制; 1->web; 2->app;
     */
    private Integer platform;

    /**
     * 优惠卷数量
     */
    private Integer couponCount;

    /**
     * 优惠卷金额
     */
    private BigDecimal couponAmount;

    /**
     * 每人限领数量
     */
    private Integer personLimit;

    /**
     * 使用门槛: 0->无门槛
     */
    private Integer useThreshold;

    /**
     * 可以领取的时间
     */
    private Date publishDate;

    /**
     * 优惠卷开始时间
     */
    private Date startDate;

    /**
     * 结束时间
     */
    private Date endDate;

    /**
     * 使用类型: 0->全场通用; 1->指定分类; 2->指定商品
     */
    private Integer useType;

    /**
     * 优惠卷使用规则
     */
    private String couponRemark;

    /**
     * 发行数量
     */
    private Integer publishCount;

    /**
     * 已使用数量
     */
    private Integer useCount;

    /**
     * 领取数量
     */
    private Integer receiveCount;

    /**
     * 优惠码
     */
    private String couponCode;

    /**
     * 可领取的会员等级: 0->无限制
     */
    private Integer memberLevel;

    /**
     * 创建时间
     */
    private Date createDate;

    /**
     * 创建用户
     */
    private Long createBy;

    /**
     * 最后更新时间
     */
    private Date lastUpdateDate;

    /**
     * 最后更新用户
     */
    private Long lastUpdateBy;

    /**
     * 乐观锁
     */
    private Integer version;

    /**
     * 逻辑删除
     */
    private Integer deleteStatus;
}
