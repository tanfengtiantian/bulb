package com.maxzuo.juc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * ScheduledExecutorService 的主要作用就是可以将定时任务与线程池功能结合使用。
 * Created by zfh on 2019/03/01
 */
public class ScheduledExecutorServiceExample {

    private static final Logger logger = LoggerFactory.getLogger(ScheduledExecutorServiceExample.class);

    public static void main(String[] args) {
        ThreadFactoryExample threadFactory = new ThreadFactoryExample("一号机房");
        RejectedHandlerExample rejectedHandler = new RejectedHandlerExample();
        ScheduledExecutorService scheduled = new ScheduledThreadPoolExecutor(5, threadFactory, rejectedHandler);

        for (int i = 1; i <= 10; i++) {
            final int number = i;
            scheduled.scheduleAtFixedRate(new Runnable() {
                @Override
                public void run() {
                    try {
                        System.out.println(Thread.currentThread().getName() + "---------" + number);
                        TimeUnit.SECONDS.sleep(3);
                    } catch (Exception e) {
                        logger.error("schedule exception", e);
                    }
                }
            }, 0, 10, TimeUnit.SECONDS);
        }

        //scheduled.shutdown();
    }
}
