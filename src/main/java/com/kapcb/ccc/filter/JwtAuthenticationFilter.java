package com.kapcb.ccc.filter;

import com.kapcb.ccc.enums.StringPool;
import com.kapcb.ccc.utils.AccessAddressUtil;
import com.kapcb.ccc.utils.JwtAuthenticationUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * <a>Title: JwtFilter </a>
 * <a>Author: Kapcb <a>
 * <a>Description:  <a>
 * 确保在一次请求只通过一次filter，而不需要重复执行
 *
 * @author Kapcb
 * @version 1.0.0
 * @date 2021/8/13 20:28
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        // 获取请求头的token
        String authorization = request.getHeader(StringPool.HTTP_REQUEST_AUTHORIZATION.value());
        log.info("::::access authorization is : {}", authorization);
        String ipAddress = AccessAddressUtil.getIpAddress(request);
        log.info("::::ip address is : {}", ipAddress);

        if (StringUtils.isNotBlank(authorization) && authorization.startsWith(StringPool.AUTHORIZATION_BEARER.value())) {
            // 从Authorization获取token
            String accessToken = authorization.substring(StringPool.AUTHORIZATION_BEARER.value().length());
            log.info("::::access token is : {}", accessToken);
            if (StringUtils.isNotBlank(accessToken)) {
                String username = JwtAuthenticationUtil.parseToken(accessToken);
                log.info("::::username is : {}", username);
                if (StringUtils.isNotBlank(username)) {

                    // 检查用户名是否加入黑名单

                    // 判断是否
                    log.info("::::access success!");

                }

            }
        }
        filterChain.doFilter(request, response);
    }
}
