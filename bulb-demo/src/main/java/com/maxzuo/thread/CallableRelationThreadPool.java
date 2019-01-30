package com.maxzuo.thread;

import java.util.concurrent.*;

/**
 * 探索Callable、Future和FutureTask
 * @See http://www.cnblogs.com/dolphin0520/p/3949310.html
 * Created by zfh on 2019/1/22
 */
public class CallableRelationThreadPool {

    public static void main(String[] args) {
        BlockingQueue<Runnable> queue = new LinkedBlockingQueue<>(2);
        UserThreadFactory threadFactory = new UserThreadFactory("一号机房");
        UserRejectHandler rejectHandler = new UserRejectHandler();
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(1, 10, 60, TimeUnit.SECONDS, queue, threadFactory, rejectHandler);

        System.out.println("main threadId：" + Thread.currentThread().getId());
        // 1.使用Callable+Future获取执行结果（子线程）
        CallableTask task1 = new CallableTask();
        Future<Integer> result = threadPool.submit(task1);
        try {
            System.out.println("task执行结果：" + result.get());
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 2.使用Callable+FutureTask获取执行结果（子线程）
        CallableTask task2 = new CallableTask();
        FutureTask<Integer> futureTask = new FutureTask<>(task2);
        threadPool.submit(futureTask);
        try {
            System.out.println("futureTask执行结果：" + futureTask.get());
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 关闭线程池
        threadPool.shutdown();
    }
}

/**
 * 实现Callable接口的方式创建线程
 * Created by zfh on 2019/01/22
 */
class CallableTask implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        System.out.println("CallableTask threadId：" + Thread.currentThread().getId());
        Thread.sleep(3000);
        return 1;
    }
}