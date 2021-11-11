package com.kapcb.ccc.controller;

import com.kapcb.framework.security.validation.IValidateCodeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <a>Title: CaptchaController </a>
 * <a>Author: Kapcb <a>
 * <a>Description: CaptchaController <a>
 *
 * @author Kapcb
 * @version 1.0.0
 * @date 2021/11/11 21:46
 */
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("captcha")
public class CaptchaController {

    private final HttpServletRequest request;
    private final HttpServletResponse response;
    private final IValidateCodeService validateCodeService;

    @GetMapping("create")
    public void create() {
        try {
            validateCodeService.create(request, response);
        } catch (Exception e) {
            log.error("111");
        }
    }
}
