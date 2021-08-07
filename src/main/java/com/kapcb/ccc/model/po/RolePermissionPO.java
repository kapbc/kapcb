package com.kapcb.ccc.model.po;

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
@TableName(value = "kapcb.role_permission")
public class RolePermissionPO implements Serializable {

    private static final long serialVersionUID = 1311095667573626727L;

    private Long permissionId;

    private Long roleId;

    private Date createDate;

    private Long createBy;
}