package com.kapcb.ccc.model.po.coupon;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * <a>Title: CouponProductCategoryRelationPO </a>
 * <a>Author: Kapcb <a>
 * <a>Description: CouponProductCategoryRelationPO <a>
 *
 * @author Kapcb
 * @version 1.0.0
 * @date 2021/11/6 13:14
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CouponProductCategoryRelationPO implements Serializable {

    private static final long serialVersionUID = 4538036719280468801L;

    /**
     * 自增主键id
     */
    private Long relationId;

    /**
     * 优惠卷id
     */
    private Long couponId;

    /**
     * 商品类目id
     */
    private Integer categoryId;

    /**
     * 商品类目名称
     */
    private String categoryName;

    /**
     * 商品类目父级id
     */
    private Integer parentCategoryId;

    /**
     * 商品类目父级名称
     */
    private String parentCategoryName;

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
