package com.maxzuo.juc.locks;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Condition的特性
 * <pre>
 *  1.Condition中的await()方法相当于Object的wait()方法，Condition中的signal()方法相当于Object的notify()方法，
 *    Condition中的signalAll()相当于Object的notifyAll()方法。不同的是，Object中的这些方法是和同步锁捆绑使用的；
 *    而Condition是需要与互斥锁/共享锁捆绑使用的。
 *  2.Condition它更强大的地方在于：能够更加精细的控制多线程的休眠与唤醒。对于同一个锁，我们可以创建多个Condition，
 *    在不同的情况下使用不同的Condition。
 * </pre>
 * Created by zfh on 2019/03/12
 */
public class ConditionExample {

    private static final ReentrantLock LOCK = new ReentrantLock();

    private static final Condition     STOP = LOCK.newCondition();

    public static void main(String[] args) {
        // TODO: 使用线程池会有问题？

        // 线程1
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " ------- hello t1");

                try {
                    LOCK.lock();
                    STOP.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    LOCK.unlock();
                }

                System.out.println("t1 end ...");
            }
        });
        t1.start();

        // 线程2
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " -------- hello t2");
                try {
                    TimeUnit.SECONDS.sleep(2);

                    LOCK.lock();
                    STOP.signal();

                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    LOCK.unlock();
                }
                System.out.println("t2 end ...");
            }
        });
        t2.start();

        System.out.println("hello condition");
    }
}
