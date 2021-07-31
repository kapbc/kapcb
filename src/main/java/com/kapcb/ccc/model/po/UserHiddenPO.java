package com.kapcb.ccc.model.po;

import java.util.Date;

/**
 * <a>Title: UserHiddenPO </a>
 * <a>Author: Kapcb <a>
 * <a>Description: User Hidden PO <a>
 *
 * @author Kapcb
 * @version 1.0.0
 * @date 2021/7/31 12:40
 */
public class UserHiddenPO {

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 选择的用户
     */
    private Long chooseUserId;

    /**
     * 隐藏类型 online 在线状态
     */
    private String hiddenType;

    /**
     * 创建时间
     */
    private Date createDate;

    /**
     * 创建人
     */
    private Long createBy;
}
