package com.kapcb.ccc.service.impl;

import com.kapcb.ccc.model.dto.user.UserLoginDTO;
import com.kapcb.ccc.service.AuthService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;

/**
 * <a>Title: AuthServiceImpl </a>
 * <a>Author: Kapcb <a>
 * <a>Description:  <a>
 *
 * @author Kapcb
 * @version 1.0.0
 * @date 2021/7/16 22:46
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    @Override
    public String login(UserLoginDTO userLoginDTO) {
        String message = "";
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(userLoginDTO.getEmail(), userLoginDTO.getPassword());
        try {
            subject.login(usernamePasswordToken);
        } catch (Exception e) {

        }
        return null;
    }
}
