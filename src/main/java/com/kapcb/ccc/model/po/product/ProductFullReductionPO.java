package com.kapcb.ccc.model.po.product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * <a>Title: ProductFullReductionPO </a>
 * <a>Author: Kapcb <a>
 * <a>Description: ProductFullReductionPO <a>
 *
 * @author Kapcb
 * @version 1.0.0
 * @date 2021/11/6 12:25
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductFullReductionPO implements Serializable {

    private static final long serialVersionUID = 8742315055684085882L;

    /**
     * 主键自增id
     */
    private Long reductionId;

    /**
     * 商品id
     */
    private Long productId;

    /**
     * 满减价格
     */
    private BigDecimal fullPrice;

    /**
     * 减少的价格
     */
    private BigDecimal reductionPrice;

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

