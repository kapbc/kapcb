package com.kapcb.ccc.model.po;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * <a>Title: ProductDraftPO </a>
 * <a>Author: Kapcb <a>
 * <a>Description:  <a>
 *
 * @author Kapcb
 * @version 1.0.0
 * @date 2021/8/1 22:27
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class ProductDraftPO implements Serializable {

    private static final long serialVersionUID = 3810902000332372280L;

    /**
     * 产品草稿版本id
     */
    private Long productDraftId;

    /**
     * 产品id
     */
    private Long productId;

    /**
     * 商店id
     */
    private Long storeId;

    /**
     * 产品名称
     */
    private String productName;

    /**
     * 产品描述
     */
    private String productDescription;

    /**
     * 审核状态
     */
    private String reviewStatus;

    /**
     * 审核时间
     */
    private Date reviewDate;

    /**
     * 审核人
     */
    private Long reviewBy;

    /**
     * 创建时间
     */
    private Date createDate;

    /**
     * 创建人
     */
    private Long createBy;

    /**
     * 最后更新时间
     */
    private Date lastUpdateDate;

    /**
     * 最后更新人
     */
    private Long lastUpdateBy;
}
