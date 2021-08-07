package com.kapcb.ccc.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.time.Duration;

/**
 * <a>Title: ShiroRedisProperties </a>
 * <a>Author: Kapcb <a>
 * <a>Description:  <a>
 *
 * @author Kapcb
 * @version 1.0.0
 * @date 2021/8/7 12:58
 */
@Data
@ConfigurationProperties(prefix = "spring.redis", ignoreInvalidFields = true)
public class ShiroRedisProperties {

    private String host = "localhost";

    private int port = 6379;

    private String password;

    private Duration timeout;

}
