package com.kapcb.ccc.model.po.product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * <a>Title: ProductStepPricePO </a>
 * <a>Author: Kapcb <a>
 * <a>Description: ProductStepPricePO <a>
 *
 * @author Kapcb
 * @version 1.0.0
 * @date 2021/11/5 22:30
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductStepPricePO implements Serializable {

    private static final long serialVersionUID = -8605636339459980283L;

    /**
     * 自增主键id
     */
    private Long stepPriceId;

    /**
     * 商品id
     */
    private Long productId;

    /**
     * 数量
     */
    private Integer count;

    /**
     * 则扣
     */
    private BigDecimal discount;

    /**
     * 价格
     */
    private BigDecimal price;

    /**
     * 创建用户id
     */
    private Long createBy;

    /**
     * 创建时间
     */
    private Date createDate;

    /**
     * 最后更新用户id
     */
    private Long lastUpdateBy;

    /**
     * 最后更新时间
     */
    private Date lastUpdateDate;

    /**
     * 逻辑删除
     */
    private Integer deleteStatus;

    /**
     * 乐观锁
     */
    private Integer version;
}
