package com.maxzuo.juc;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * SingleThreadExecutor线程池
 * <pre>
 *   创建一个单线程的线程池，相当于单线程串行执行所有任务，保证按任务的提交顺序依次执行。
 *   如果这个唯一的线程因为异常结束，那么会有一个新的线程替代它。
 * </pre>
 * Created by zfh on 2019/03/30
 */
public class SingleThreadExecutorExample {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("hello thread");
            }
        });
    }
}
