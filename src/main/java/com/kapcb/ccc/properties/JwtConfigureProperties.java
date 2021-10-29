package com.kapcb.ccc.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * <a>Title: JwtConfigureProperties </a>
 * <a>Author: Kapcb <a>
 * <a>Description: JwtConfigureProperties <a>
 *
 * @author Kapcb
 * @version 1.0.0
 * @date 2021/10/29 20:19
 */
@Data
@ConfigurationProperties(prefix = "jwt.secret")
public class JwtConfigureProperties {

    private String secretKey = "kapcb";

    private Long expiration = 60 * 60 * 24L;
}
