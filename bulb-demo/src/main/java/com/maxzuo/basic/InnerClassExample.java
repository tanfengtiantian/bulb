package com.maxzuo.basic;

/**
 * 内部类（成员内部类、局部内部类、静态内部类、匿名内部类）
 * <p>
 * Created by zfh on 2019/04/14
 */
public class InnerClassExample {

    public static void main(String[] args) {
        // 静态成员
        Slow slow = new Slow();

        // 实例成员
        InnerClassExample innerClassExample = new InnerClassExample();
        Fast fast = innerClassExample.new Fast();
    }

    /**
     * 成员内部类
     */
    class Fast {

        public Fast() {
            System.out.println("Fast class init ...");
        }
    }

    /**
     * 静态内部类
     */
    static class Slow {

        public Slow() {
            System.out.println("Slow class init ...");
        }
    }
}
