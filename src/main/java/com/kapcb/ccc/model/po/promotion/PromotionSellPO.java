package com.kapcb.ccc.model.po.promotion;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * <a>Title: SecondsKillPO </a>
 * <a>Author: Kapcb <a>
 * <a>Description: SecondsKillPO <a>
 *
 * @author Kapcb
 * @version 1.0.0
 * @date 2021/11/6 13:27
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PromotionSellPO implements Serializable {

    private static final long serialVersionUID = -3345027558508143499L;

    /**
     * 自增主键id
     */
    private Long promotionId;

    /**
     * 促销标题
     */
    private String promotionTitle;

    /**
     * 促销开始时间
     */
    private Date startDate;

    /**
     * 促销结束时间
     */
    private Date endDate;

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
     * 逻辑删除
     */
    private Integer deleteStatus;

    /**
     * 乐观锁
     */
    private Integer version;
}
