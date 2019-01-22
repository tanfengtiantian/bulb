package com.maxzuo.thread;

import java.util.concurrent.atomic.AtomicLong;

/**
 * 任务执行体
 * Created by zfh on 2018/11/24
 */
public class Task implements Runnable {

    private final AtomicLong count = new AtomicLong(0L);

    @Override
    public void run() {
        System.out.println("running_" + count.getAndIncrement());
    }
}
