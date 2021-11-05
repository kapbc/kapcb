package com.kapcb.ccc.model.po.admin;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.Version;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * <a>Title: User </a>
 * <a>Author: Kapcb <a>
 * <a>Description:  <a>
 *
 * @author Kapcb
 * @version 1.0.0
 * @date 2021/7/31 12:35
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TableName(value = "user_grp.user")
public class UserPO implements Serializable {

    private static final long serialVersionUID = -3821173666664111882L;

    /**
     * 用户id
     */
    @TableId(value = "user_id", type = IdType.AUTO)
    private Long userId;

    /**
     * 店铺id
     */
    @TableField("supplier_id")
    private Long supplierId;

    /**
     * 紧急联系人id
     */
    @TableField("emergency_contact_id")
    private Long emergencyContactId;

    /**
     * 昵称
     */
    @TableField("user_name")
    private String username;

    /**
     * 密码
     */
    @TableField("password")
    private String password;

    /**
     * 邮箱
     */
    @TableField("email")
    private String email;

    /**
     * 性别
     */
    @TableField("gender")
    private Integer gender;

    @TableField("country_code")
    private String countryCode;

    @TableField("area_code")
    private String areaCode;

    @TableField("city_code")
    private String cityCode;

    @TableField("user_star_level")
    private Integer userStarLevel;

    @TableField("available_status")
    private Boolean availableStatus;

    @TableField("user_info_score")
    private Integer userInfoScore;

    @TableField("user_credit_score")
    private Integer userCreditScore;

    @TableField("create_by")
    private Long createBy;

    @TableField("last_update_by")
    private Long lastUpdateBy;

    @TableField("birthday")
    private Date birthday;

    @TableField("create_date")
    private Date createDate;

    @TableField("last_update_date")
    private Date lastUpdateDate;

    @TableField("order_by_date")
    private Date orderByDate;

    @TableField("job_title")
    private String jobTitle;

    @TableField("telephone_number")
    private String telephoneNumber;

    @TableField("online_status")
    private String onlineStatus;

    @TableField("remark")
    private String remark;

    @TableField("head_sculpture")
    private String headSculpture;

    @TableField("user_source")
    private String userSource;

    @Version
    @TableField("version")
    private Integer version;

    @TableField("supplier_flag")
    private Boolean supplierFlag;
}
