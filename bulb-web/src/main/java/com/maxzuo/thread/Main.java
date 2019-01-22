package com.maxzuo.thread;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 线程池测试
 * Created by zfh on 2018/11/24
 */
public class Main {

    public static void main(String[] args) {
        BlockingQueue<Runnable> queue = new LinkedBlockingQueue<>(1);
        UserThreadFactory threadFactory = new UserThreadFactory();
        UserRejectHandler rejectHandler = new UserRejectHandler();
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 20, 60, TimeUnit.SECONDS, queue, threadFactory, rejectHandler);

        SaleTicketsTask task = new SaleTicketsTask();
        threadPoolExecutor.execute(task);
        threadPoolExecutor.shutdown();
    }
}

class SaleTicketsTask implements Runnable{

    private int tickets = 100;

    @Override
    public void run() {
        saleTickets();
    }

    private void saleTickets () {
        while (true) {
            if (tickets > 0) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "：" + tickets--);
            } else {
                System.out.println("票已售完");
                break;
            }
        }
    }
}