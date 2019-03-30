package com.maxzuo.juc;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 线程工厂
 * Created by zfh on 2019/02/24
 */
public class ThreadFactoryExample implements ThreadFactory {

    private final AtomicInteger nextId = new AtomicInteger(1);

    private final String        namePrefix;

    public ThreadFactoryExample(String name) {
        namePrefix = "UserThreadFactory's " + name + "-Worker-";
    }

    @Override
    public Thread newThread(Runnable task) {
        String name = namePrefix + nextId.getAndIncrement();
        Thread thread = new Thread(null, task, name, 0);
        thread.setDaemon(true);
        return thread;
    }
}
