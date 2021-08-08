package com.kapcb.ccc.model.dto.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * <a>Title: AuthenticationDTO </a>
 * <a>Author: Kapcb <a>
 * <a>Description:  <a>
 *
 * @author Kapcb
 * @version 1.0.0
 * @date 2021/8/8 15:38
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthenticationDTO implements Serializable {

    private static final long serialVersionUID = -7640648459609230860L;

    private String username;

    private String password;
}
