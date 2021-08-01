package com.kapcb.ccc.model.po;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * <a>Title: StoreOnlinePO </a>
 * <a>Author: Kapcb <a>
 * <a>Description:  <a>
 *
 * @author Kapcb
 * @version 1.0.0
 * @date 2021/8/1 22:56
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class StoreOnlinePO implements Serializable {

    private static final long serialVersionUID = -1393666567365896440L;

    /**
     * 店铺在线表id
     */
    private Long storeOnlineId;

    /**
     * 店铺id
     */
    private Long storeId;

    /**
     * 合同id集合
     */
    private List<Long> contractIds;

    /**
     * 店铺等级
     */
    private Integer storeLevel;

    /**
     * 店铺名称
     */
    private String storeName;

    /**
     * 主营产品类型
     */
    private String businessType;

    /**
     * 店铺是否有人在线
     */
    private String storeOnlineStatus;


    private Boolean deleteFlag;

    private Integer version;

    private Long createBy;

    private Long lastUpdateBy;

    private Date createDate;

    private Date lastUpdateDate;
}
