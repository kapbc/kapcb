package com.kapcb.ccc.model.po;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * <a>Title: LifeCyclePO </a>
 * <a>Author: Kapcb <a>
 * <a>Description:  <a>
 *
 * @author Kapcb
 * @version 1.0.0
 * @date 2021/8/2 22:50
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class LifeCyclePO implements Serializable {

    private static final long serialVersionUID = 8186866661991326649L;

    private Long lifeCycleId;

    private String lifeCycleType;

    private Long storeId;

    private Long productId;

    private String remark;

    private Boolean deleteFlag;

    private Integer version;

    private Date createDate;

    private Long createBy;

    private Date lastUpdateDate;

    private Long lastUpdateBy;
}
