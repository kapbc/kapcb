package com.kapcb.ccc.annotation.web;

import com.kapcb.ccc.configure.IndexConfiguration;
import com.kapcb.ccc.properties.ShiroRedisProperties;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * <a>Title: KapcbWebApplication </a>
 * <a>Author: Kapcb <a>
 * <a>Description:  <a>
 *
 * @author Kapcb
 * @version 1.0.0
 * @date 2021/8/4 21:19
 */
@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@SpringBootApplication(exclude = {RedisAutoConfiguration.class})
@EnableConfigurationProperties(value = {
        IndexConfiguration.class,
        ShiroRedisProperties.class
})
@MapperScan(basePackages = {"com.kapcb.ccc.mapper"})
public @interface KapcbWebApplication {
}
