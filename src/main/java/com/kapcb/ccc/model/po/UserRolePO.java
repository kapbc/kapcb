package com.kapcb.ccc.model.po;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * <a>Title: UserRolePO </a>
 * <a>Author: Kapcb <a>
 * <a>Description:  <a>
 *
 * @author Kapcb
 * @version 1.0.0
 * @date 2021/7/16 22:35
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@TableName(value = "kapcb.user_role")
public class UserRolePO implements Serializable {

    private static final long serialVersionUID = -2064339372703488229L;

    private Long userId;

    private Long roleId;

    private Date createDate;

    private Long createBy;
}
