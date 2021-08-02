package com.kapcb.ccc.model.po;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * <a>Title: ContractPO </a>
 * <a>Author: Kapcb <a>
 * <a>Description:  <a>
 *
 * @author Kapcb
 * @version 1.0.0
 * @date 2021/8/2 22:20
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class ContractPO implements Serializable {

    private static final long serialVersionUID = 4095646262020175407L;

    /**
     * 合同id
     */
    private Long contactId;

    /**
     * 店铺id
     */
    private Long stareId;

    /**
     * 合同类型
     */
    private String contractType;

    /**
     * 合同状态
     */
    private String contractStatus;

    /**
     * 逻辑删除
     */
    private Boolean deleteFlag;

    /**
     * 合同开始日期
     */
    private Date startDate;

    /**
     * 合同结束日期
     */
    private Date expireDate;

    /**
     * 乐观锁
     */
    private Integer version;

    /**
     * 创建人
     */
    private Long createBy;

    /**
     * 创建时间
     */
    private Date createDate;

    /**
     * 最后更新人
     */
    private Long lastUpdateBy;

    /**
     * 最后更新时间
     */
    private Date lastUpdateDate;
}
