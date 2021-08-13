package com.kapcb.ccc.filter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import java.nio.charset.StandardCharsets;
import java.util.Calendar;

/**
 * <a>Title: JwtFilter </a>
 * <a>Author: Kapcb <a>
 * <a>Description:  <a>
 *
 * @author Kapcb
 * @version 1.0.0
 * @date 2021/8/13 20:28
 */
@Slf4j
public class JwtAuthenticationFilter extends BasicAuthenticationFilter {

    public JwtAuthenticationFilter(AuthenticationManager authenticationManager) {
        super(authenticationManager);
    }

    public JwtAuthenticationFilter(AuthenticationManager authenticationManager, AuthenticationEntryPoint authenticationEntryPoint) {
        super(authenticationManager, authenticationEntryPoint);
    }

    public static void main(String[] args) {

        Calendar calendar = Calendar.getInstance();
        calendar.set(2021, 8, 15, 12, 12, 12);

        String sign = JWT.create().withExpiresAt(calendar.getTime()).withClaim("role", "admin")
                .withClaim("role", "user").withAudience("kapcb").sign(Algorithm.HMAC256("kapcb".getBytes(StandardCharsets.UTF_8)));

        System.out.println("sign = " + sign);

        String s = JWT.decode(sign).getAudience().get(0);
        System.out.println("s = " + s);
        JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256("kapcb".getBytes(StandardCharsets.UTF_8))).build();
        System.out.println("jwtVerifier = " + jwtVerifier);
        DecodedJWT verify = jwtVerifier.verify(sign);

    }
}
