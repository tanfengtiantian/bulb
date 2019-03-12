package com.maxzuo.thread;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 探索线程池
 * <pre>
 * 阿里开发规约
 *  1.创建线程或线程池时请指定有意义的线程名称，方便出错时回溯。
 *  2.线程资源必须通过线程池提供，不允许在应用中自行显示创建线程。
 *  3.线程池不允许使用Executors，而是通过ThreadPoolExecutor的方式创建，这样的处理方式能更加准确线程池的运行规则，规避资源耗尽的风险。
 * </pre>
 * Created by zfh on 2019/01/22
 */
public enum ThreadPoolExample {
    INSTANCE;

    private ThreadPoolExecutor threadPool;

    ThreadPoolExample () {
        BlockingQueue<Runnable> queue = new LinkedBlockingQueue<>(1);
        ThreadFactoryExample threadFactory = new ThreadFactoryExample("一号机房");
        RejectedHandlerExample rejectHandler = new RejectedHandlerExample();
        threadPool = new ThreadPoolExecutor(1, 10, 60, TimeUnit.SECONDS, queue, threadFactory, rejectHandler);
    }

    public void execute(Runnable task) {
        threadPool.execute(task);
    }
}
