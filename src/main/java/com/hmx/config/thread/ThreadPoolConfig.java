package com.hmx.config.thread;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import javax.annotation.Resource;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author hanmingxiang 2018-05-07 19:39
 */
@Configuration
@EnableAsync
public class ThreadPoolConfig {

    @Resource
    private ThreadPoolProperties properties;

    @Bean
    public Executor taskExecutor(){
        ThreadPoolTaskExecutor taskExecutor=new ThreadPoolTaskExecutor();
        taskExecutor.setCorePoolSize(properties.getCorePoolSize());
        taskExecutor.setMaxPoolSize(properties.getMaxPoolSize());
        taskExecutor.setKeepAliveSeconds(properties.getKeepAliveSeconds());
        taskExecutor.setQueueCapacity(properties.getQueueCapacity());
        taskExecutor.setRejectedExecutionHandler(new ThreadPoolExecutor.AbortPolicy());
        taskExecutor.setThreadNamePrefix(properties.getThreadNamePrefix());
        return taskExecutor;
    }

}
