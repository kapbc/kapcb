package com.kapcb.ccc.handler;

import cn.hutool.http.ContentType;
import com.kapcb.ccc.utils.JsonUtil;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * <a>Title: RestfulAccessDeniedHandler </a>
 * <a>Author: Kapcb <a>
 * <a>Description: RestfulAccessDeniedHandler <a>
 *
 * @author Kapcb
 * @version 1.0.0
 * @date 2021/10/29 22:15
 */
@Component
public class RestfulAccessDeniedHandler implements AccessDeniedHandler {

    @Override
    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AccessDeniedException e) throws IOException, ServletException {
        httpServletResponse.setCharacterEncoding("UTF-8");
        httpServletResponse.setContentType(ContentType.JSON.getValue());
        Map<String, Object> resultMap = new HashMap<>(2);
        resultMap.put("msg", "forbidden");
        resultMap.put("code", "500");
        httpServletResponse.getWriter().write(JsonUtil.toJsonString(resultMap));
        httpServletResponse.getWriter().flush();
        httpServletResponse.getWriter().close();
    }
}
