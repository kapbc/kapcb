package com.kapcb.ccc.model.dto.user.req;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * <a>Title: UserListRequestDTO </a>
 * <a>Author: Kapcb <a>
 * <a>Description:  <a>
 *
 * @author Kapcb
 * @version 1.0.0
 * @date 2021/7/31 14:13
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class UserListRequestDTO implements Serializable {

    private static final long serialVersionUID = 3916261054984288616L;

    @ApiModelProperty(value = "页数(默认值为1)", required = true)
    private long pageNum;

    @ApiModelProperty(value = "每页显示条数(默认值为10)", required = true)
    private long pageSize;

    @JsonIgnore
    private Long storeId;

    private String query;
}
