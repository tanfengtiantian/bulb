package com.maxzuo.proxy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * Java设计模式-代理模式
 * <p>
 * Created by zfh on 2019/04/03
 */
class ProxyPatternExample {

    @DisplayName("静态代理模式")
    @Test
    void testStaticProxy() {
        ProxySubject proxySubject = new ProxySubject(new RealSubject());
        // 由代理类，代理访问
        proxySubject.visit();
    }

    @DisplayName("动态代理")
    @Test
    void testDynamicProxy() {
        // 返回一个代理对象（Subject接口的实现类）
        Subject subjectProxy = (Subject) Proxy.newProxyInstance(Subject.class.getClassLoader(), new Class[]{Subject.class},
                new InvocationHandler() {
                    /**
                     * 将方法调用分派到的调用处理程序
                     * @param proxy  表示真实对象的真实代理对象，jvm运行时动态生成的一个对象，也是Proxy.newProxyInstance()返回的对象
                     * @param method 表示当前被调用方法的反射对象
                     * @param args   表示当前被调用方法的参数
                     * @return 表示当前被调用的方法的返回值
                     * @throws Throwable
                     */
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("inner: " + proxy.getClass().getName());

                        // 要代理的真实对象
                        Subject subject = new Subject() {
                            @Override
                            public void visit() {
                                System.out.println("hello subject");
                            }

                            @Override
                            public String getSubject() {
                                return "Subjec proxy";
                            }
                        };
                        // 通过真实对象调用方法
                        return method.invoke(subject, args);
                    }
                });

        // 代理对象无论调用什么方法，其实都是调用InvocationHandler.invoke()方法
        System.out.println("outer：" + subjectProxy.getClass().getName());
        subjectProxy.visit();
        //System.out.println(subjectProxy.getSubject());
        //System.out.println(subjectProxy.toString());
    }
}
