package com.kapcb.ccc.model.po.coupon;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * <a>Title: CouponProductRelationPO </a>
 * <a>Author: Kapcb <a>
 * <a>Description: CouponProductRelationPO <a>
 *
 * @author Kapcb
 * @version 1.0.0
 * @date 2021/11/6 13:20
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CouponProductRelationPO implements Serializable {

    private static final long serialVersionUID = -8513624152157308898L;

    /**
     * 自增主键id
     */
    private Long relationId;

    /**
     * 优惠卷id
     */
    private Long couponId;

    /**
     * 商品id
     */
    private Long productId;

    /**
     * 商品名称
     */
    private String productName;

    /**
     * 商品编号
     */
    private String productSerialNumber;

    /**
     * 创建时间
     */
    private Date createDate;

    /**
     * 创建用户id
     */
    private Long createBy;

    /**
     * 最后更新时间
     */
    private Date lastUpdateDate;

    /**
     * 最后更新用户id
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
