package com.kapcb.ccc.model.po.order;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * <a>Title: OrderOperationHistory </a>
 * <a>Author: Kapcb <a>
 * <a>Description: OrderOperationHistory <a>
 *
 * @author Kapcb
 * @version 1.0.0
 * @date 2021/11/4 22:36
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderOperationHistory implements Serializable {

    private static final long serialVersionUID = -567961879064199417L;

    /**
     * 订单操作历史id
     */
    private Long operationHistoryId;

    /**
     * 订单id
     */
    private Long orderId;

    /**
     * 操作用户id
     */
    private Long createBy;

    /**
     * 操作时间
     */
    private Date createDate;

    /**
     * 订单状态: 0->待付款; 1->代发货; 2->已发货; 3->已完成; 4->已关闭; 5->无效订单; 6->删除订单;
     */
    private Integer orderStatus;

    /**
     * 订单操作备注
     */
    private String operationRemark;
}
