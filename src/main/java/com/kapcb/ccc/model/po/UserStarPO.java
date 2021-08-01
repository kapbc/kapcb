package com.kapcb.ccc.model.po;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * <a>Title: UserStarPO </a>
 * <a>Author: Kapcb <a>
 * <a>Description:  <a>
 * 用户收藏产品或者店铺
 *
 * @author Kapcb
 * @version 1.0.0
 * @date 2021/8/1 23:35
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class UserStarPO implements Serializable {

    private static final long serialVersionUID = 7868015286125714880L;

    private Long userStarId;

    private Long productId;

    private Long storeId;

    private String starType;

    private Long userId;

    private Integer version;

    private Boolean deleteFlag;

    private Long createBy;

    private Date creteDate;

    private Long lastUpdateBy;

    private Date lastUpdateDate;

}
