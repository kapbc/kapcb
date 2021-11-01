package com.kapcb.ccc.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * <a>Title: ThreadPoolProperties </a>
 * <a>Author: Kapcb <a>
 * <a>Description: ThreadPoolProperties <a>
 *
 * @author Kapcb
 * @version 1.0.0
 * @date 2021/11/1 21:28
 */
@Data
@ConfigurationProperties(prefix = "kapcb.thread", ignoreInvalidFields = true)
public class ThreadPoolProperties {

    private int corePoolSize = 5;

    private int maxPoolSize = 5;

    private int queueCapacity = 999;

    private int keepAliveSeconds = 30;

    private String threadNamePrefix = "kapcb-async-";
}
