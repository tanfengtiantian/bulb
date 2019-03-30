package com.maxzuo.juc;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * CachedThreadPool线程池
 * <pre>
 *   线程数最大Integer.MAX_VALUE，是高度可伸缩的线程池，存在OOM风险。keepAliveTime默认为60秒，工作线程处于空闲状态，则回收工作线程。
 *   如果任务数增加，再次创建新线程处理任务。
 * </pre>
 * Created by zfh on 2019/03/30
 */
public class CachedThreadPoolExample {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("hello cached thread pool");
            }
        });

    }
}
