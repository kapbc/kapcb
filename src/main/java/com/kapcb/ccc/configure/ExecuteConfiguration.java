package com.kapcb.ccc.configure;

import com.kapcb.ccc.execute.CustomThreadPoolTaskExecutor;
import com.kapcb.ccc.properties.ThreadPoolProperties;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
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
@EnableAsync
@Configuration
@RequiredArgsConstructor
public class ExecuteConfiguration {

    private final ThreadPoolProperties threadPool;

    @Bean("asyncExecuteService")
    public Executor asyncExecuteService() {
        ThreadPoolTaskExecutor executor = new CustomThreadPoolTaskExecutor();
        // 核心线程数
        executor.setCorePoolSize(threadPool.getCorePoolSize());
        // 最大线程数
        executor.setMaxPoolSize(threadPool.getMaxPoolSize());
        // 队列大小
        executor.setQueueCapacity(threadPool.getQueueCapacity());
        // 线程池中的线程名称前缀
        executor.setThreadNamePrefix(threadPool.getThreadNamePrefix());
        // 线程活跃时间
        executor.setKeepAliveSeconds(threadPool.getKeepAliveSeconds());
        // rejection-policy 当pool达到max size的时候, 处理新任务的策略
        // CALLER_RUNS 不在新线程中执行, 而是调用者所在线程来执行
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        // 等待所有任务执行玩之后关闭
        executor.setWaitForTasksToCompleteOnShutdown(true);
        // 执行初始化
        executor.initialize();
        return executor;
    }
}
