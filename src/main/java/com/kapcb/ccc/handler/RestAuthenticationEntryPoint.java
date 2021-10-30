package com.kapcb.ccc.handler;

import cn.hutool.http.ContentType;
import com.kapcb.ccc.utils.JsonUtil;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

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
        httpServletResponse.setCharacterEncoding("UTF-8");
        httpServletResponse.setContentType(ContentType.JSON.getValue());
        Map<String, Object> resultMap = new HashMap<>(2);
        resultMap.put("msg", "unauthorized");
        resultMap.put("code", "300");
        httpServletResponse.getWriter().write(JsonUtil.toJsonString(resultMap));
        httpServletResponse.getWriter().flush();
        httpServletResponse.getWriter().close();
    }
}
