/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.maxzuo.threadpool.support.cached;

import com.maxzuo.threadpool.Constants;
import com.maxzuo.threadpool.NamedThreadFactory;
import com.maxzuo.threadpool.ThreadPool;
import com.maxzuo.threadpool.ThreadPoolConfig;
import com.maxzuo.threadpool.support.AbortPolicyWithReport;

import java.util.concurrent.*;

/**
 * This thread pool is self-tuned. Thread will be recycled after idle for one minute, and new thread will be created for
 * the upcoming request.
 *
 * @see Executors#newCachedThreadPool()
 */
public class CachedThreadPool implements ThreadPool {

    @Override
    public ExecutorService getExecutor(ThreadPoolConfig config) {
        String name = config.getName() == null ? Constants.DEFAULT_THREAD_NAME : config.getName();
        int cores = config.getCores() == null ? Constants.DEFAULT_CORE_THREADS : config.getCores();
        int threads = config.getThreads() == null ? Integer.MAX_VALUE : config.getThreads();
        int alive = config.getAlive() == null ? Constants.DEFAULT_ALIVE : config.getAlive();
        int queues = config.getQueues() == null ? Constants.DEFAULT_QUEUES : config.getQueues();
        return new ThreadPoolExecutor(cores, threads, alive, TimeUnit.MICROSECONDS,
                queues == 0 ? new SynchronousQueue<>() :
                        (queues < 0 ? new LinkedBlockingQueue<>()
                                : new LinkedBlockingQueue<>(queues)),
                new NamedThreadFactory(name, true),
                new AbortPolicyWithReport(name));
    }
}
