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
package com.maxzuo.threadpool.cached;

import com.maxzuo.threadpool.AbortPolicyWithReport;
import com.maxzuo.threadpool.NamedThreadFactory;
import com.maxzuo.threadpool.ThreadPool;

import java.util.concurrent.*;

/**
 * This thread pool is self-tuned. Thread will be recycled after idle for one minute, and new thread will be created for
 * the upcoming request.
 *
 * @see java.util.concurrent.Executors#newCachedThreadPool()
 */
public class CachedThreadPool implements ThreadPool {

    private static final Integer THREAD_CORES = 2;

    private static final Integer THREAD_MAX = 10;

    private static final Integer QUEUES = 10;

    @Override
    public ThreadPoolExecutor getExecutor(String threadFactoryName) {
        return new ThreadPoolExecutor(THREAD_CORES, THREAD_MAX, 60, TimeUnit.SECONDS,
                QUEUES == 0 ? new SynchronousQueue<>() :
                        (QUEUES < 0 ? new LinkedBlockingQueue<>()
                                : new LinkedBlockingQueue<>(QUEUES)),
                new NamedThreadFactory(threadFactoryName, true),
                new AbortPolicyWithReport(threadFactoryName));
    }
}
