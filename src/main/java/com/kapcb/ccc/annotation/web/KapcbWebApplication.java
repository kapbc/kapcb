package com.kapcb.ccc.annotation.web;

import com.kapcb.ccc.configure.IndexConfiguration;
import com.kapcb.ccc.properties.EndPointAutoConfigureProperties;
import com.kapcb.ccc.properties.ShiroRedisProperties;
import com.kapcb.ccc.properties.ThreadPoolProperties;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.elasticsearch.ElasticsearchDataAutoConfiguration;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;

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
@SpringBootApplication(exclude = {RedisAutoConfiguration.class,
        ElasticsearchDataAutoConfiguration.class})
@EnableConfigurationProperties(value = {
        IndexConfiguration.class,
        ShiroRedisProperties.class,
        ThreadPoolProperties.class,
        EndPointAutoConfigureProperties.class
})
@MapperScan(basePackages = {"com.kapcb.ccc.mapper"})
@ComponentScan(value = {"com.kapcb.ccc.*", "com.ejlchina.searcher.support.boot"})
public @interface KapcbWebApplication {
}
