package com.maxzuo.thread.concurrent;

import org.apache.commons.lang3.RandomUtils;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * CountDownLatch使用案例：三个工人先全部干完活，老板才检查。
 * <pre>
 *  1.Java的concurrent包里面的CountDownLatch其实可以把它看作一个计数器，只不过这个计数器的操作是原子操作，同时只能有一个线程去操作
 *  这个计数器，也就是同时只能有一个线程去减这个计数器里面的值。
 *  2.你可以向CountDownLatch对象设置一个初始的数字作为计数值，任何调用这个对象上的await()方法都会阻塞，直到这个计数器的计数值被其他
 *  的线程减为0为止。
 * </pre>
 * Created by zfh on 2019/01/29
 */
public class CountDownLatchTest {

    public static void main(String[] args) {
        BlockingQueue<Runnable> queue = new LinkedBlockingQueue<>(10);
        TempThreadFactory threadFactory = new TempThreadFactory("一号机房");
        TempRejectHandler rejectHandler = new TempRejectHandler();
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(1, 10, 60, TimeUnit.SECONDS, queue, threadFactory, rejectHandler);

        CountDownLatch downLatch = new CountDownLatch(3);
        Worker worker1 = new Worker(downLatch, "一号");
        Worker worker2 = new Worker(downLatch, "二号");
        Worker worker3 = new Worker(downLatch, "三号");
        Boss boss = new Boss(downLatch);

        poolExecutor.execute(worker1);
        poolExecutor.execute(worker2);
        poolExecutor.execute(worker3);
        poolExecutor.execute(boss);

        poolExecutor.shutdown();
    }
}

/** 工人类 */
class Worker implements Runnable {

    private CountDownLatch downLatch;

    private String name;

    Worker (CountDownLatch downLatch, String name) {
        this.downLatch = downLatch;
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println(name + " 开始工作！");
        try {
            TimeUnit.SECONDS.sleep(RandomUtils.nextInt(1, 3));
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            downLatch.countDown();
            System.out.println(name + " 干完活了！");
        }
    }
}

/** 老板类 */
class Boss implements Runnable {

    private CountDownLatch downLatch;

    Boss (CountDownLatch downLatch) {
        this.downLatch = downLatch;
    }

    @Override
    public void run() {
        try {
            downLatch.await();
            System.out.println("老板开始检查！");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

/** 线程工厂 */
class TempThreadFactory implements ThreadFactory {

    private final AtomicInteger nextId = new AtomicInteger(1);

    private final String namePrefix;

    TempThreadFactory (String name) {
        namePrefix = "UserThreadFactory's " + name + "-Worker-";
    }

    @Override
    public Thread newThread(Runnable task) {
        String name = namePrefix + nextId.getAndIncrement();
        Thread thread = new Thread(null, task, name, 0);
        System.out.println(thread.getName());
        return thread;
    }
}

/** 拒绝策略 */
class TempRejectHandler implements RejectedExecutionHandler {

    @Override
    public void rejectedExecution(Runnable task, ThreadPoolExecutor executor) {
        System.out.println("task rejected：" + executor.toString());
    }
}