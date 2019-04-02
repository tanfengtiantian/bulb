package com.maxzuo.agent.model;

/**
 * Created by zfh on 2019/03/22
 */
public class Monday {

    public Monday() {
        System.out.println("getContextClassLoader()：" + Thread.currentThread().getContextClassLoader());

        System.out.println("before thuesday classLoader: " + Thuesday.class.getClassLoader());
        Thuesday thuesday = new Thuesday();
        System.out.println("after thuesday classLoader: " + thuesday.getClass().getClassLoader());
    }
}
