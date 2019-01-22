package com.maxzuo.thread;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 线程工厂
 * Created by zfh on 2018/11/24
 */
public class UserThreadFactory implements ThreadFactory {

    private final AtomicInteger atomicInteger = new AtomicInteger(1);

    @Override
    public Thread newThread(Runnable r) {
        // 起名字，完成线程实例化
        String name = "worker-" + atomicInteger.getAndIncrement();
        return new Thread(null, r, name, 0);
    }
}


