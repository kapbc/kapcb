package com.kapcb.ccc.model.po.product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * <a>Title: ProductOperationLogPO </a>
 * <a>Author: Kapcb <a>
 * <a>Description: ProductOperationLogPO <a>
 *
 * @author Kapcb
 * @version 1.0.0
 * @date 2021/11/5 22:42
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductOperationLogPO implements Serializable {

    private static final long serialVersionUID = -2163301752465156071L;

    private Long operationLogId;

    /**
     * 操作产品id
     */
    private Long productId;

    /**
     * 业务操作类型
     */
    private Integer businessType;

    /**
     * 操作用户
     */
    private Long createBy;

    /**
     * 操作时间
     */
    private Date createDate;

    /**
     * 操作结果: 0->失败; 1->成功; 2->代码报错;
     */
    private Integer operationResult;
}
