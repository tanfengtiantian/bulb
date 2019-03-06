package com.maxzuo.thread;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/**
 * Created by zfh on 2019/01/30
 */
class CallableTest {

    @DisplayName("Callable的使用")
    @Test
    void testUseCallable() {
        Callable<String> callable = new Callable<String>() {
            @Override
            public String call() {
                System.out.println("threadId：" + Thread.currentThread().getId());
                try {
                    TimeUnit.SECONDS.sleep(3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return "hello call";
            }
        };
        try {
            System.out.println("main threadId：" + Thread.currentThread().getId());
            // 阻塞中，使用的同一个线程
            callable.call();
            System.out.println("main thread execute done");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @DisplayName("FutureTask的使用")
    @Test
    void testFutureTask() {
        Callable callable = new Callable<String>() {
            @Override
            public String call() {
                try {
                    System.out.println("threadId：" + Thread.currentThread().getId());
                    TimeUnit.SECONDS.sleep(3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return "执行完毕";
            }
        };

        FutureTask<String> task = new FutureTask(callable);
        Thread t = new Thread(task);
        t.start();
        System.out.println("main threadId：" + Thread.currentThread().getId());
        System.out.println("开始执行！");
        try {
            // 使用的子线程，调用get()方法阻塞
            String result = task.get();
            System.out.println("result：" + result);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("阻塞完毕！");
    }
}
