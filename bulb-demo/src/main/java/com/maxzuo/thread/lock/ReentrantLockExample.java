package com.maxzuo.thread.lock;

import com.maxzuo.thread.ThreadPoolExample;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 可重入锁 ReentrantLock
 * Created by zfh on 2019/03/12
 */
public class ReentrantLockExample {

    private static final Logger logger = LoggerFactory.getLogger(ReentrantLockExample.class);

    private static final ReentrantLock LOCK = new ReentrantLock();

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            ThreadPoolExample.INSTANCE.execute(new Runnable() {
                @Override
                public void run() {
                    task();
                }
            });
        }

    }

    /**
     * task body
     */
    private static void task () {
        LOCK.lock();
        try {
            System.out.println(Thread.currentThread().getName() + " --------- in coming");
            TimeUnit.SECONDS.sleep(1);
        } catch (Exception e) {
            logger.error("发生异常", e);
        } finally {
            LOCK.unlock();
        }
    }
}
