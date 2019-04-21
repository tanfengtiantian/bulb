package com.maxzuo.juc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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

    private static final Logger logger = LoggerFactory.getLogger(com.maxzuo.juc.ThreadPoolExample.class);

    public static void main(String[] args) throws InterruptedException {
        customThreadPool();

        TimeUnit.SECONDS.sleep(Integer.MAX_VALUE);
    }

    /**
     * 自定义线程池
     */
    private static void customThreadPool() {
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(1, 10, 60,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(1),
                new NamedThreadFactory("一号机房"),
                new RejectedHandlerExample());

        // submit()方法，可以提供Future < T > 类型的返回值。
        Future<?> future = threadPool.submit(new Callable<Object>() {
            @Override
            public Object call() throws Exception {
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    System.out.println("线程中断异常");
                }
                return "hello call";
            }
        });
        // 询问是否执行完毕
        while (!future.isDone()) {
            try {
                System.out.println("result：" + future.get());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

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
    private static void ExecutorService() {
        /*
            核心线程数量，也是最大线程数量，不存在空闲线程
            创建一个定长线程池，可控制线程最大并发数，超出的线程会在队列中等待。
         */
        Executors.newFixedThreadPool(1);

        // 创建一个单线程化的线程池，它只会用唯一的工作线程来执行任务，保证所有任务按照指定顺序(FIFO, LIFO, 优先级)执行。
        // 当线程执行中出现异常，去创建一个新的线程替换之
        Executors.newSingleThreadExecutor();

        // 线程数最大Integer.MAX_VALUE，是高度可伸缩的线程池，存在OOM风险。keepAliveTime默认为60秒，工作线程处于空闲状态，则回收工作线程。如果任务数增加，再次创建新线程处理任务。
        Executors.newCachedThreadPool();

        /*
            ScheduledExecutorService 的主要作用就是可以将定时任务与线程池功能结合使用。
         */
        ScheduledExecutorService scheduled = new ScheduledThreadPoolExecutor(5, new NamedThreadFactory("一号机房"),
            new RejectedHandlerExample());
        scheduled.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println(Thread.currentThread().getName());
                    TimeUnit.SECONDS.sleep(3);
                } catch (Exception e) {
                    logger.error("schedule exception", e);
                }
            }
        }, 0, 10, TimeUnit.SECONDS);

        // JDK 8 新增的一种线程池，获取当前可用的线程数量进行创建作为并行级别，底层调用的是ForkJoinPool线程池
        // 创建一个拥有多个任务队列的线程池，可以减少连接数，创建当前可用cpu数量的线程来并行执行，适用于大耗时的操作，可以并行来执行
        Executors.newWorkStealingPool();
    }
}
