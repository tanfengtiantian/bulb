package com.maxzuo.threadpool.support.fixed;

import com.zxcity.common.threadpool.Constants;
import com.zxcity.common.threadpool.NamedThreadFactory;
import com.zxcity.common.threadpool.ThreadPool;
import com.zxcity.common.threadpool.ThreadPoolConfig;
import com.zxcity.common.threadpool.support.AbortPolicyWithReport;

import java.util.concurrent.*;

/**
 * Creates a thread pool that reuses a fixed number of threads
 *
 * @see Executors#newFixedThreadPool(int)
 * Created by zfh on 2019/04/18
 */
public class FixedThreadPool implements ThreadPool {

    @Override
    public ExecutorService getExecutor(ThreadPoolConfig config) {
        String name = config.getName() == null ? Constants.DEFAULT_THREAD_NAME : config.getName();
        int threads = config.getThreads() == null ? Constants.DEFAULT_THREADS : config.getThreads();
        int queues = config.getQueues() == null ? Constants.DEFAULT_QUEUES : config.getQueues();
        return new ThreadPoolExecutor(threads, threads, 0, TimeUnit.MILLISECONDS,
                queues == 0 ? new SynchronousQueue<>() :
                        (queues < 0 ? new LinkedBlockingQueue<>()
                                : new LinkedBlockingQueue<>(queues)),
                new NamedThreadFactory(name, true), new AbortPolicyWithReport(name));
    }
}
