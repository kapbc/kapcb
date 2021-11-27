package com.kapcb.ccc.controller;

import com.kapcb.framework.common.result.CommonResult;
import com.kapcb.framework.logging.annotation.Logging;
import com.kapcb.framework.security.exception.ValidateCodeException;
import com.kapcb.framework.security.validation.IValidateCodeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

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

    private final IValidateCodeService validateCodeService;

    @GetMapping("create")
    @Logging(stackTraceOnError = true)
    public void create(HttpServletRequest request, HttpServletResponse response) throws IOException {
        validateCodeService.create(request, response);
    }

    @GetMapping("verify")
    @Logging(stackTraceOnError = true, tags = "#key")
    public CommonResult<String> verify(@RequestParam("key") String key, @RequestParam("code") String code) {
        try {
            validateCodeService.verify(key, code);
        } catch (ValidateCodeException e) {
            log.error("verify error, error message is : {}", e.getMessage());
            return CommonResult.failed("validate code error");
        }
        return CommonResult.success(null, "validate success");
    }
}
