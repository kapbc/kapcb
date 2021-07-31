package com.kapcb.ccc.model.po;

import java.util.Date;

/**
 * <a>Title: UserLoginLogPO </a>
 * <a>Author: Kapcb <a>
 * <a>Description:  <a>
 *
 * @author Kapcb
 * @version 1.0.0
 * @date 2021/7/31 12:35
 */
public class UserLoginLogPO {

    /**
     * 用户登录日志id
     */
    private Long userLoginLogId;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 登陆时间
     */
    private Date loginDate;

    /**
     * 登录ip地址
     */
    private String loginIpAddress;

    /**
     * 登录国家code
     */
    private String loginCountryCode;

    /**
     * 登录地区code
     */
    private String loginAreaCode;

    /**
     * 登录设备
     */
    private String userLoginAgent;

    /**
     * 是否逻辑删除
     */
    private Boolean deleteFlag;
}
