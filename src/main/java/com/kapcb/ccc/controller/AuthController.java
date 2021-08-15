package com.kapcb.ccc.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class AuthController {

    @GetMapping("login.html")
    public String login() {
        return "login";
    }

    @GetMapping("index")
    public String index(){
        return "index";
    }
}
