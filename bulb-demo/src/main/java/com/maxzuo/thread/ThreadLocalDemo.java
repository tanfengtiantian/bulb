package com.maxzuo.thread;

/**
 * 探索ThreadLocal对象
 * Created by zfh on 2019/01/22
 */
public class ThreadLocalDemo {

    private static final ThreadLocal<Integer> THREAD_LOCAL = new ThreadLocal<>();

    public static void main(String[] args) {
        THREAD_LOCAL.set(1);
        System.out.println(THREAD_LOCAL.get());
        THREAD_LOCAL.remove();
        System.out.println(THREAD_LOCAL.get());
    }
}
