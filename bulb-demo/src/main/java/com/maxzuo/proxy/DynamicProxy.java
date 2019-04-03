package com.maxzuo.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * 创建一个动态代理类，实现InvocationHandler接口，并重写invoke()方法
 * <p>
 * Created by zfh on 2019/04/03
 */
public class DynamicProxy implements InvocationHandler {

    /**
     * 将方法调用分派到的调用处理程序
     * @param proxy  方法所调用的代理实例
     * @param method 目标方法
     * @param args   方法的入参
     * @return 代理类调用目标方法的执行结果
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println(proxy.getClass().getName());
        System.out.println("method: " + method);
        System.out.println("args: " + Arrays.toString(args));

        // 创建接口的代理对象
        Subject proxyObject = new Subject() {
            @Override
            public void visit() {
                System.out.println("hello subject");
            }
        };
        // 通过代理对象调用方法，得到结果
        return method.invoke(proxyObject, args);
    }
}
