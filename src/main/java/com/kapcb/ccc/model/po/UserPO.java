package com.kapcb.ccc.model.po;


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
public class UserPO implements Serializable {

    private static final long serialVersionUID = -3821173666664111882L;

    private Long userId;

    private Long storeId;

    private Long emergencyContactUserId;

    private String firstName;

    private String lastName;

    private String nickName;

    private String password;

    private String email;

    private Integer age;

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

    private String userJobTitle;

    private String telephonePrefix;

    private String telephoneAcceptCountryCode;

    private String telephoneAreaCode;

    private String telephoneNumber;

    private String onlineStatus;

    private String remark;

    private String headSculpture;

    private String userSource;
}
