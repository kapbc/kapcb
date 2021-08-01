package com.kapcb.ccc.model.po;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * <a>Title: StoreReviewRecordPO </a>
 * <a>Author: Kapcb <a>
 * <a>Description:  <a>
 *
 * @author Kapcb
 * @version 1.0.0
 * @date 2021/8/1 23:29
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class ReviewRecordPO implements Serializable {

    private static final long serialVersionUID = 6858483530341073845L;

    private Long storeReviewRecordId;

    /**
     * 店铺id
     */
    private Long storeId;

    /**
     * 产品id
     */
    private Long productId;

    /**
     * product / store
     */
    private String reviewType;

    /**
     * 审核人
     */
    private Long reviewBy;

    private String reviewResult;

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
