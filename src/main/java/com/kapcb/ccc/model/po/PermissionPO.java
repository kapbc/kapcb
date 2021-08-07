package com.kapcb.ccc.model.po;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * <a>Title: PermissionPO </a>
 * <a>Author: Kapcb <a>
 * <a>Description:  <a>
 *
 * @author Kapcb
 * @version 1.0.0
 * @date 2021/8/1 14:59
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@TableName(value = "kapcb.permission")
public class PermissionPO implements Serializable {

    private static final long serialVersionUID = -5227962994068651933L;

    /**
     * 权限id
     */
    private Long permissionId;

    /**
     * 权限名称
     */
    private String permissionName;

    /**
     * 权限标识
     */
    private String permissionIdentify;

    /**
     * 权限描述
     */
    private String permissionDescription;

    /**
     * 乐观锁
     */
    private Integer version;

    /**
     * 权限是否可用
     */
    private Boolean availableStatus;

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

    /**
     * 排序时间
     */
    private Date orderByDate;
}
