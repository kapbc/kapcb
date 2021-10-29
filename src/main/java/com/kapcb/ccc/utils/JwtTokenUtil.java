package com.kapcb.ccc.utils;

import com.kapcb.ccc.context.ApplicationContextProvider;
import com.kapcb.ccc.properties.JwtConfigureProperties;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <a>Title: JwtTokenUtil </a>
 * <a>Author: Kapcb <a>
 * <a>Description: JwtTokenUtil <a>
 *
 * @author Kapcb
 * @version 1.0.0
 * @date 2021/10/29 20:06
 */
@Slf4j
@UtilityClass
public class JwtTokenUtil {

    private static final String USER_ID = "id";
    private static final String CLAIM_KEY_USERNAME = "sub";
    private static final String CLAIM_KEY_CREATED = "created";
    private static final Calendar calendar = Calendar.getInstance();
    private static final JwtConfigureProperties jwtConfigureProperties;

    static {
        jwtConfigureProperties = ApplicationContextProvider.getBean("jwtConfigureProperties", JwtConfigureProperties.class);
    }

    public static String generateToke(String username, Long userId) {
        Map<String, Object> claims = new HashMap<>(2);
        claims.put(CLAIM_KEY_USERNAME, username);
        claims.put(USER_ID, userId);
        claims.put(CLAIM_KEY_CREATED, calendar.getTime());
        return generateJwtToken(claims);
    }

    public static Claims getClaims(String token) {
        if (StringUtils.isBlank(token)) {
            throw new IllegalArgumentException("jwt token can not be null or empty");
        }
        Claims claims = null;
        try {
            claims = Jwts.parser()
                    .setSigningKey(jwtConfigureProperties.getSecretKey())
                    .parseClaimsJws(token)
                    .getBody();
        } catch (Exception e) {
            log.error("get claims from jwt token error, error message is : {}", e.getMessage());
        }
        return claims;
    }

    public static String getUsername(String token) {
        String username = null;
        try {
            Claims claims = getClaims(token);
            if (Objects.nonNull(claims)) {
                username = claims.getSubject();
            }
        } catch (Exception e) {
            log.error("get username from token error, error message is : {}", e.getMessage());
        }
        return username;
    }

    public static Long userId(String token) {
        Long userId = null;
        try {
            Claims claims = getClaims(token);
            if (Objects.nonNull(claims)) {
                userId = (Long) claims.get(USER_ID);
            }
        } catch (Exception e) {
            log.error("get user id from token error, error message is : {}", e.getMessage());
        }
        return userId;
    }

    public static boolean validateToken(String token, Long userId) {

    }

    public static boolean expired(String token) {
        Date expirationDate = getExpirationDate(token);
        if (Objects.isNull(expirationDate)) {
            throw new IllegalArgumentException("jwt expiration can not be null or empty");
        }
        return expirationDate.before(calendar.getTime());
    }

    private Date getExpirationDate(String token) {
        Date expiration = null;
        try {
            Claims claims = getClaims(token);
            if (Objects.nonNull(claims)) {
                expiration = claims.getExpiration();
            }
        } catch (Exception e) {
            log.error("get expiration from token error, error message is : {}", e.getMessage());
        }
        return expiration;
    }

    private static String generateJwtToken(Map<String, Object> claims) {
        if (MapUtils.isEmpty(claims)) {
            throw new IllegalArgumentException("claims can not be null or empty");
        }
        return Jwts.builder()
                .setClaims(claims)
                .setExpiration(generateExpirationDate())
                .signWith(SignatureAlgorithm.HS512, jwtConfigureProperties.getSecretKey())
                .compact();
    }

    private static Date generateExpirationDate() {
        calendar.setTimeInMillis(System.currentTimeMillis() + (jwtConfigureProperties.getExpiration() * 1000));
        return calendar.getTime();
    }
}
