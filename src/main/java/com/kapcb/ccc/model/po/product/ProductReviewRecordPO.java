package com.kapcb.ccc.model.po.product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * <a>Title: ProductReviewRecordPO </a>
 * <a>Author: Kapcb <a>
 * <a>Description: ProductReviewRecordPO <a>
 *
 * @author Kapcb
 * @version 1.0.0
 * @date 2021/11/5 22:35
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductReviewRecordPO implements Serializable {

    private static final long serialVersionUID = -2394191507583785771L;

    private Long reviewRecordId;

    /**
     * 商品id
     */
    private Long productId;

    /**
     * 创建用户id
     */
    private Long createBy;

    /**
     * 创建时间
     */
    private Date createDate;

    /**
     * 审核状态: 0->待审核; 1->审核通过;
     */
    private Integer reviewStatus;

    /**
     * 审核备注
     */
    private String reviewRemark;
}
