package com.kapcb.ccc.utils;

import com.google.common.collect.Maps;
import com.kapcb.ccc.enums.StringPool;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.SneakyThrows;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import java.io.InputStream;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <a>Title: JwtAuthenticationUtil </a>
 * <a>Author: Kapcb <a>
 * <a>Description:  <a>
 *
 * @author Kapcb
 * @version 1.0.0
 * @date 2021/8/13 22:57
 */
@Slf4j
@UtilityClass
public class JwtAuthenticationUtil {

    private static final String KEY_STORE_PASSWORD = "123456";

    private static final String AUTHORITIES = "Authorities";

    /**
     * 证书私钥、公钥、文件
     */
    private static PublicKey publicKey;
    private static PrivateKey privateKey;
    private static InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("jwt.jks");

    /**
     * 取出证书中的私钥公钥
     */
    static {
        try {
            KeyStore keyStore = KeyStore.getInstance("JKS");
            keyStore.load(inputStream, KEY_STORE_PASSWORD.toCharArray());
            //  jwt 为 命令生成整数文件时的别名
            privateKey = (PrivateKey) keyStore.getKey("jwt", KEY_STORE_PASSWORD.toCharArray());
            publicKey = keyStore.getCertificate("jwt").getPublicKey();
        } catch (Exception e) {
            System.out.println("::::load key error");
        }
    }

    /**
     * generate jwt token
     *
     * @param subject String
     * @param ttl     Long
     * @param claims  Map<String, Object>
     * @return String
     */
    @NonNull
    public static String generateToken(@NonNull String subject, @NonNull Long ttl, @Nullable Map<String, Object> claims) {
        long currentTimeMillis = System.currentTimeMillis();
        ttl = currentTimeMillis + ttl;
        log.info("::::the jwt ttl time is : {}", ttl);
        try {
            JwtBuilder builder = Jwts.builder();
            if (MapUtils.isNotEmpty(claims)) {
                builder.setClaims(claims);
            }
            return builder.setSubject(subject)
                    .setExpiration(new Date(ttl))
                    .signWith(SignatureAlgorithm.RS256, privateKey)
                    .compact();
        } catch (Exception e) {
            log.error("::::generate jwt token error, error message is : {}", e.getMessage());
        }
        return StringPool.EMPTY_STRING.value();
    }

    /**
     * parse jwt token
     *
     * @param token String
     * @return String
     */
    @NonNull
    public static String parseToken(@NonNull String token) {
        String subject = StringPool.EMPTY_STRING.value();
        try {
            Claims tokenClaims = getTokenClaims(token);
            if (Objects.nonNull(tokenClaims)) {
                subject = tokenClaims.getSubject();
            }
        } catch (Exception e) {
            log.error("::::parse token error, error message is : {}", e.getMessage());
        }
        return subject;
    }

    /**
     * get claims from jwt token
     *
     * @param token String
     * @return Map<String, Object>
     */
    @NonNull
    public static Map<String, Object> getClaims(@NonNull String token) {
        Map<String, Object> claims = Maps.newHashMap();
        try {
            Claims tokenClaims = getTokenClaims(token);
            if (Objects.nonNull(tokenClaims)) {
                claims = tokenClaims;
            }
        } catch (Exception e) {
            log.error("::::get claims error, error message is : {}", e.getMessage());
        }
        return claims;
    }

    public static boolean expired(@NonNull Date expireDate) {
        log.info("::::expire date is : {}", expireDate);
        return expireDate.after(new Date());
    }

    /**
     * 获取token中的自定义属性
     *
     * @param token String
     * @return Claims
     */
    @Nullable
    @SneakyThrows(Exception.class)
    private static Claims getTokenClaims(@NonNull String token) {
        if (StringUtils.isNoneBlank(token)) {
            return Jwts.parser()
                    .setSigningKey(publicKey)
                    .parseClaimsJws(token)
                    .getBody();
        }
        return null;
    }

    public static void main(String[] args) {
        Map<String, Object> claims = new HashMap<>(4);
        claims.put("role", Arrays.asList("admin", "user", "boss"));
        claims.put("userId", 1000000000L);
        String token = JwtAuthenticationUtil.generateToken("Mike", 1000000000L, claims);
        System.out.println("token = " + token);

        String subject = JwtAuthenticationUtil.parseToken(token);
        System.out.println("subject = " + subject);
        Map<String, Object> claims1 = JwtAuthenticationUtil.getClaims(token);
        System.out.println("claims1 = " + claims1);
    }
}
