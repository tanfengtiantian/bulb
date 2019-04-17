package com.maxzuo.thread;

import com.maxzuo.juc.RejectedHandlerExample;
import com.maxzuo.juc.ThreadFactoryExample;

import java.util.concurrent.*;

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
public class ThreadPoolExample {


    public static void main(String[] args) throws InterruptedException {
        customThreadPool();

        TimeUnit.SECONDS.sleep(Integer.MAX_VALUE);
    }

    /**
     * 自定义线程池
     */
    private static void customThreadPool () {
        BlockingQueue<Runnable> queue = new LinkedBlockingQueue<>(1);
        ThreadFactoryExample threadFactory = new ThreadFactoryExample("一号机房");
        RejectedHandlerExample rejectHandler = new RejectedHandlerExample();
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(1, 10, 60, TimeUnit.SECONDS, queue, threadFactory, rejectHandler);

        // submit()方法，可以提供Future < T > 类型的返回值。
        threadPool.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("hello one");
            }
        });

        // executor()方法，无返回值。
        threadPool.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("hello two");
            }
        });
    }

    /**
     * ExecutorService
     */
    private static void ExecutorService () {
        // 创建一个定长线程池，可控制线程最大并发数，超出的线程会在队列中等待。
        Executors.newFixedThreadPool(1);

        // 创建一个单线程化的线程池，它只会用唯一的工作线程来执行任务，保证所有任务按照指定顺序(FIFO, LIFO, 优先级)执行。
        // 当线程执行中出现异常，去创建一个新的线程替换之
        Executors.newSingleThreadExecutor();

        // 创建一个可缓存线程池，如果线程池长度超过处理需要，可灵活回收空闲线程，若无可回收，则新建线程。默认为60s未使用就被终止和移除。
        Executors.newCachedThreadPool();

        // 创建一个定长线程池，支持定时及周期性任务执行。
        Executors.newSingleThreadExecutor();

        // JDK 8 新增的一种线程池，获取当前可用的线程数量进行创建作为并行级别，底层调用的是ForkJoinPool线程池
        // 创建一个拥有多个任务队列的线程池，可以减少连接数，创建当前可用cpu数量的线程来并行执行，适用于大耗时的操作，可以并行来执行
        Executors.newWorkStealingPool();
    }
}
