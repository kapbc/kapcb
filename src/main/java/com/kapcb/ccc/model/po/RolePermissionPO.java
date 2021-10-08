package com.kapcb.ccc.model.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * <a>Title: RolePermissionPO </a>
 * <a>Author: Kapcb <a>
 * <a>Description:  <a>
 *
 * @author Kapcb
 * @version 1.0.0
 * @date 2021/8/1 15:07
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@TableName(value = "user_grp.role_permission")
public class RolePermissionPO implements Serializable {

    private static final long serialVersionUID = 1311095667573626727L;

    @TableId(type = IdType.AUTO, value = "permission_id")
    private Long permissionId;

    @TableField(value = "role_id")
    private Long roleId;

    @TableField(value = "create_date")
    private Date createDate;

    @TableField(value = "create_by")
    private Long createBy;
}