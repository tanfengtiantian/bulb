package com.maxzuo.juc.atomic;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * Atomic包的AtomicInteger的简单使用
 * Created by zfh on 2019/02/24
 */
public class AtomicIntegerExample {

    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger();
        // Unsafe类的CAS操作，从而保证了线程安全。
        atomicInteger.incrementAndGet();
        System.out.println(atomicInteger);

        testAtomicStampedReference();
    }

    /** 解决Java中 CAS-ABA问题 */
    private static void testAtomicStampedReference () {
        int stamp = 100;
        AtomicStampedReference<Integer> atomicStampedReference = new AtomicStampedReference<>(10,stamp);
        atomicStampedReference.compareAndSet(10, 11, stamp, --stamp);
        System.out.println(atomicStampedReference.getReference());
    }
}
