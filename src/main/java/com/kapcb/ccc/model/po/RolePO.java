package com.kapcb.ccc.model.po;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * <a>Title: RolePO </a>
 * <a>Author: Kapcb <a>
 * <a>Description:  <a>
 *
 * @author Kapcb
 * @version 1.0.0
 * @date 2021/8/1 14:52
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@TableName(value = "kapcb.role")
public class RolePO implements Serializable {

    private static final long serialVersionUID = 1284732956591701003L;

    /**
     * 角色id 自增
     */
    private Long roleId;

    /**
     * 角色名称 不允许重复
     */
    private String roleName;

    /**
     * 角色标识
     */
    private String roleIdentify;

    /**
     * 乐观锁
     */
    private Integer version;

    /**
     * 角色是否可用
     */
    private Boolean availableStatus;

    /**
     * 备注
     */
    private String roleDescription;

    /**
     * 排序时间
     */
    private Date orderByDate;

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
     * 角色类型
     */
    private String roleType;

    /**
     * 是否是兜底角色
     */
    private Boolean basicRole;
}
