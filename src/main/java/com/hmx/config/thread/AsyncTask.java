package com.hmx.config.thread;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.concurrent.Future;

/**
 * @author hanmingxiang 2018-05-08 10:54
 */
@Component
public class AsyncTask {

    private final Logger logger = LoggerFactory.getLogger(AsyncTask.class);

    @Async
    public Future<Long> asyncSend(String msg){
        long start = System.currentTimeMillis();
        logger.info("开始发送"+msg);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        logger.info("发送完成"+msg);
        return new AsyncResult<>(System.currentTimeMillis()-start);
    }
}
