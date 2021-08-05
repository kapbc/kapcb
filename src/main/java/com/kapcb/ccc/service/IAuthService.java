package com.kapcb.ccc.service;

import com.kapcb.ccc.model.dto.user.UserLoginDTO;

/**
 * <a>Title: AuthService </a>
 * <a>Author: Kapcb <a>
 * <a>Description:  <a>
 *
 * @author Kapcb
 * @version 1.0.0
 * @date 2021/7/16 22:46
 */
public interface IAuthService {

    String login(UserLoginDTO userLoginDTO);
}
