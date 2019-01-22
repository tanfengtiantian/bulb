package com.maxzuo.thread;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

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
public class ThreadPoolDemo {

    private final static Integer TASK_NUM = 100;

    public static void main(String[] args) {
        BlockingQueue<Runnable> queue = new LinkedBlockingQueue<>(2);
        UserThreadFactory threadFactory = new UserThreadFactory("一号机房");
        UserRejectHandler rejectHandler = new UserRejectHandler();
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(1, 10, 60, TimeUnit.SECONDS, queue, threadFactory, rejectHandler);

        Task task = new Task();
        for (int i = 0; i < TASK_NUM; i++) {
            threadPool.execute(task);
        }
    }
}

/**
 * 线程工厂
 * Created by zfh on 2018/11/24
 */
class UserThreadFactory implements ThreadFactory {

    private final AtomicInteger nextId = new AtomicInteger(1);

    private final String namePrefix;

    UserThreadFactory (String name) {
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

/**
 * 拒绝策略
 * Created by zfh on 2018/11/24
 */
class UserRejectHandler implements RejectedExecutionHandler {

    @Override
    public void rejectedExecution(Runnable task, ThreadPoolExecutor executor) {
        System.out.println("task rejected：" + executor.toString());
    }
}

/**
 * 任务线程
 * Created by zfh on 2018/11/24
 */
class Task implements Runnable {

    private final AtomicLong count = new AtomicLong(0L);

    @Override
    public void run() {
        System.out.println("running_" + count.getAndIncrement());
    }
}

