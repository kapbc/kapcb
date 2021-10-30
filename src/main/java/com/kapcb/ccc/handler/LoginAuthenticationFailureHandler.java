package com.kapcb.ccc.handler;

import cn.hutool.http.ContentType;
import com.kapcb.ccc.utils.JsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * <a>Title: LoginAuthenticationFailureHandler </a>
 * <a>Author: Kapcb <a>
 * <a>Description:  <a>
 *
 * @author Kapcb
 * @version 1.0.0
 * @date 2021/8/8 15:01
 */
@Slf4j
@Component
public class LoginAuthenticationFailureHandler implements AuthenticationFailureHandler {

    @Override
    public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        httpServletResponse.setContentType(ContentType.JSON.getValue());
        Map<String, Object> resultMap = new HashMap<>(2);
        resultMap.put("code", "-1");
        resultMap.put("data", "login fail!");
        resultMap.put("msg", "username or password error!");
        String s = JsonUtil.convertObjectToString(resultMap);
        httpServletResponse.getWriter().write(s);
        httpServletResponse.getWriter().flush();
        httpServletResponse.getWriter().close();
    }
}
