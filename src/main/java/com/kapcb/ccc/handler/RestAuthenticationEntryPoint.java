package com.kapcb.ccc.handler;

import com.kapcb.ccc.common.result.CommonResult;
import com.kapcb.ccc.utils.ResultUtil;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * <a>Title: RestAuthenticationEntryPoint </a>
 * <a>Author: Kapcb <a>
 * <a>Description: RestAuthenticationEntryPoint <a>
 *
 * @author Kapcb
 * @version 1.0.0
 * @date 2021/10/29 22:27
 */
@Component
public class RestAuthenticationEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        ResultUtil.setUpJSONResponse(httpServletResponse, CommonResult.unauthorized());
    }
}
