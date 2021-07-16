package com.kapcb.ccc.controller;

import com.kapcb.ccc.model.dto.user.UserLoginDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <a>Title: AuthController </a>
 * <a>Author: Kapcb <a>
 * <a>Description:  <a>
 *
 * @author Kapcb
 * @version 1.0.0
 * @date 2021/7/16 22:30
 */
@Slf4j
@Validated
@RequestMapping
@RestController("auth")
@RequiredArgsConstructor
public class AuthController {

    @PostMapping("login")
    public void login(@Validated @RequestBody UserLoginDTO userLoginDTO){

    }
}
