package com.maxzuo.threadpool;

/**
 * 线程池配置
 * <p>
 * Created by zfh on 2019/04/18
 */
public class ThreadPoolConfig {

    private String name;

    private Integer cores;

    private Integer threads;

    private Integer queues;

    private Integer alive;

    public ThreadPoolConfig (String name, Integer threads, Integer queues) {
        this.name = name;
        this.threads = threads;
        this.queues = queues;
    }

    public ThreadPoolConfig(String name, Integer cores, Integer threads, Integer queues, Integer alive) {
        this.name = name;
        this.cores = cores;
        this.threads = threads;
        this.queues = queues;
        this.alive = alive;
    }

    public String getName() {
        return name;
    }

    public Integer getCores() {
        return cores;
    }

    public Integer getThreads() {
        return threads;
    }

    public Integer getQueues() {
        return queues;
    }

    public Integer getAlive() {
        return alive;
    }
}
