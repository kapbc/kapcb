package com.kapcb.ccc.model.po;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * <a>Title: ProductDraftReviewRecordPO </a>
 * <a>Author: Kapcb <a>
 * <a>Description:  <a>
 *
 * @author Kapcb
 * @version 1.0.0
 * @date 2021/8/1 22:43
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class ProductDraftReviewRecordPO implements Serializable {

    private static final long serialVersionUID = 8702168273270919826L;

    /**
     * 产品id
     */
    private Long productId;

    /**
     * 店铺id
     */
    private Long storeId;

    /**
     * 审核人
     */
    private Long reviewBy;

    /**
     * 审核备注
     */
    private String reviewRemark;

    /**
     * 审核时间
     */
    private Date reviewDate;

    /**
     * 最后更新人
     */
    private Long lastUpdateBy;

    /**
     * 最后更新时间
     */
    private Date lastUpdateDate;

    /**
     * 创建人
     */
    private Long createBy;

    /**
     * 创建时间
     */
    private Date createDate;
}
