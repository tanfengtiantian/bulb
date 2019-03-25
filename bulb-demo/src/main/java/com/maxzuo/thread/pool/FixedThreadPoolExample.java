package com.maxzuo.thread.pool;

import java.util.concurrent.*;

/**
 * 固定大小的线程池
 * Created by zfh on 2019/03/25
 */
public class FixedThreadPoolExample {

    /**
     * 核心线程数量，也是最大线程数量，没有等待线程。
     */
    private static final Integer MAX_NUM = 20;

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(MAX_NUM);

        Future<?> future = executorService.submit(new Callable<Object>() {
            @Override
            public Object call() throws Exception {
                return "hello call";
            }
        });

        while (!future.isDone()) {
            try {
                System.out.println("result：" + future.get());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        executorService.shutdown();
    }
}
