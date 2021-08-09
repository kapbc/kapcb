package com.kapcb.ccc.handler;

import cn.hutool.http.ContentType;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * <a>Title: LoginAuthenticationSuccessHandler </a>
 * <a>Author: Kapcb <a>
 * <a>Description:  <a>
 *
 * @author Kapcb
 * @version 1.0.0
 * @date 2021/8/8 13:57
 */
@Slf4j
@Component
public class LoginAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        httpServletResponse.setContentType(ContentType.JSON.toString());
        Map<String, Object> resultMap = new HashMap<>(2);
        resultMap.put("data", "kapcb login!");
        resultMap.put("msg", "login success!");
        resultMap.put("code", "200");
        ObjectMapper objectMapper = new ObjectMapper();
        String s = objectMapper.writeValueAsString(resultMap);
        httpServletResponse.getWriter().write(s);
        httpServletResponse.getWriter().flush();
        httpServletResponse.getWriter().close();
    }
}