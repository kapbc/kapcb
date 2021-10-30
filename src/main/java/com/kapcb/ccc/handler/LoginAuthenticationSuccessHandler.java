package com.kapcb.ccc.handler;

import cn.hutool.http.ContentType;
import com.kapcb.ccc.utils.JsonUtil;
import com.kapcb.ccc.utils.JwtTokenUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

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

    private final RequestCache requestCache = new HttpSessionRequestCache();

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        SavedRequest savedRequest = requestCache.getRequest(httpServletRequest, httpServletResponse);
        HttpSession session = httpServletRequest.getSession();

        if (Objects.isNull(session)) {
            Object attribute = session.getAttribute("SPRING_SECURITY_SAVED_REQUEST");
            log.info("redirect to user login page's url is {} ", attribute);
        }



        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        String accessToken = JwtTokenUtil.generateToke(userDetails.getUsername());
        httpServletResponse.setContentType(ContentType.JSON.getValue());
        Map<String, Object> resultMap = new HashMap<>(2);
        resultMap.put("data", accessToken);
        resultMap.put("msg", "login success!");
        resultMap.put("code", "200");
        String s = JsonUtil.toJsonString(resultMap);
        httpServletResponse.getWriter().write(s);
        httpServletResponse.getWriter().flush();
        httpServletResponse.getWriter().close();
    }
}
