package com.kapcb.ccc.model.po;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

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
    @Id
    @TableId(type = IdType.AUTO)
    private Long userId;

    /**
     * 店铺id
     */
    private Long storeId;

    /**
     * 紧急联系人id
     */
    private Long emergencyContactId;

    /**
     * first name
     */
    private String firstName;

    /**
     * last name
     */
    private String lastName;

    /**
     * 昵称
     */
    private String nickName;

    /**
     * 密码
     */
    private String password;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 性别
     */
    private Integer gender;

    private String countryCode;

    private String areaCode;

    private String cityCode;

    private Integer userStarLevel;

    private Boolean availableStatus;

    private Integer userInfoScore;

    private Integer userCreditScore;

    private Long createBy;

    private Long lastUpdateBy;

    private Date birthday;

    private Date createDate;

    private Date lastUpdateDate;

    private Date orderByDate;

    private String userJobTitle;

    private String telephonePrefix;

    private String telephoneAcceptCountryCode;

    private String telephoneAreaCode;

    private String telephoneNumber;

    private String onlineStatus;

    private String remark;

    private String headSculpture;

    private String userSource;

    private Integer version;
}
