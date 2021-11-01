package com.kapcb.ccc.configure;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * <a>Title: AsyncExecuteService </a>
 * <a>Author: Kapcb <a>
 * <a>Description: AsyncExecuteService <a>
 *
 * @author Kapcb
 * @version 1.0.0
 * @date 2021/11/1 20:52
 */
@Slf4j
@Configuration
public class ExecuteConfiguration {

    @Bean("asyncExecuteService")
    public Executor asyncExecuteService() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(5);
        executor.setMaxPoolSize(5);
        executor.setQueueCapacity(999);
        executor.setThreadNamePrefix("kapcb-async-");
        executor.setKeepAliveSeconds(30);
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        executor.setWaitForTasksToCompleteOnShutdown(true);
        executor.initialize();
        return executor;
    }
}
