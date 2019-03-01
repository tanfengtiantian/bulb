package com.maxzuo.thread;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * ScheduledExecutorService 的主要作用就是可以将定时任务与线程池功能结合使用。
 * Created by zfh on 2019/03/01
 */
public class ScheduledExecutorServiceExample {

    public static void main(String[] args) {
        ThreadFactoryExample threadFactory = new ThreadFactoryExample("一号机房");
        ScheduledExecutorService scheduled = new ScheduledThreadPoolExecutor(2, threadFactory);
        scheduled.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                System.out.println("hello schedules");
            }
        }, 0, 2, TimeUnit.SECONDS);
    }
}
