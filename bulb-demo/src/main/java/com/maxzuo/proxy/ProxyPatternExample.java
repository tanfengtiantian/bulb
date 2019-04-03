package com.maxzuo.proxy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Proxy;

/**
 * Java设计模式-代理模式
 * <p>
 * Created by zfh on 2019/04/03
 */
class ProxyPatternExample {

    @DisplayName("静态代理模式")
    @Test
    void testStaticProxy () {
        ProxySubject proxySubject = new ProxySubject(new RealSubject());
        // 由代理类，代理访问
        proxySubject.visit();
    }

    @DisplayName("动态代理")
    @Test
    void testDynamicProxy () {
        /*
            动态代理有别于静态代理，是根据代理的对象，动态创建代理类。这样，就可以避免静态代理中代理类接口过多的问题。
            动态代理是实现方式，是通过反射来实现的，借助Java自带的java.lang.reflect.Proxy,通过固定的规则生成。
         */

        // 将方法调用分派到的调用处理程序
        DynamicProxy proxy = new DynamicProxy();

        // 用于定义代理类的类加载器
        ClassLoader classLoader = proxy.getClass().getClassLoader();

        // 返回接口代理类的实例
        Subject subject = (Subject) Proxy.newProxyInstance(classLoader, new Class[]{Subject.class}, proxy);
        subject.visit();
    }
}
