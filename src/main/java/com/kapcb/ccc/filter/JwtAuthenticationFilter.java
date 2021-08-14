package com.kapcb.ccc.filter;

import com.kapcb.ccc.service.IAuthService;
import com.kapcb.ccc.service.impl.RedisService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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

    private final IAuthService authService;
    private final RedisService redisService;

    public static final String AUTHORIZATION = "Authorization";

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        // 获取请求头的token
        String authorization = request.getHeader(AUTHORIZATION);


    }
}
