package com.kapcb.ccc.model.po.promotion;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * <a>Title: PromotionSubscribePO </a>
 * <a>Author: Kapcb <a>
 * <a>Description: PromotionSubscribePO <a>
 *
 * @author Kapcb
 * @version 1.0.0
 * @date 2021/11/6 13:34
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PromotionSubscribePO implements Serializable {

    private static final long serialVersionUID = 2781056036446690362L;

    /**
     * 自增主键id
     */
    private Long subscribeId;

    /**
     * 促销订阅用户id
     */
    private Long userId;

    /**
     * 订阅商品id
     */
    private Long productId;

    /**
     * 促销商品名称
     */
    private String productName;

    /**
     * 订阅时间
     */
    private Date createDate;

    /**
     * 订阅用户id
     */
    private Long createBy;

    /**
     * 促销订阅提醒状态: 0->未提醒; 1->已提醒;
     */
    private Integer alertStatus;

    /**
     * 提醒时间
     */
    private Date alertDate;

}
