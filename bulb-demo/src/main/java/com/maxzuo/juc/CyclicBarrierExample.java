package com.maxzuo.juc;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by zfh on 2019/02/24
 */
public class CyclicBarrierExample {

    /** 请求总数 */
    private final static Integer CLIENT_TOTAL  = 100;

    private static CyclicBarrier cyclicBarrier = new CyclicBarrier(10);

    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newCachedThreadPool(new NamedThreadFactory());
        for (int i = 0; i < CLIENT_TOTAL; i++) {
            int threadNum = i;
            threadPool.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        race(threadNum);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        threadPool.shutdown();
    }

    /**
     * 允许一组线程相互等待，直到到达某个公共的屏障点，才能各自继续往下执行
     * 和CountDownLatch很相识，当计数器达到了设置的初始值时，等待的线程都将被唤醒继续执行。
     * CountDownLatch计数器只能使用一次，而CyclicBarrier是循环执行的，一组接一组的执行。
     */
    private static void race(Integer threadNum) throws InterruptedException, BrokenBarrierException {
        Thread.sleep(1000);
        System.out.println(threadNum + " is readly");
        cyclicBarrier.await();
        System.out.println(threadNum + "done!");
    }
}
