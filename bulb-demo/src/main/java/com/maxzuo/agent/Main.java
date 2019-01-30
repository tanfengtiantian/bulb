package com.maxzuo.agent;

import java.lang.instrument.Instrumentation;

/**
 * JavaAgent（代理）类
 * Created by zfh on 2019/01/20
 */
public class Main {

    /** 探针内的main方法不会执行 */
    public static void main(String[] args) {
        System.out.println("hello world!");
    }

    /**
     * 探针入口方法
     * <pre>
     * 1.当命令启动该代理jar时，JVM会根据manifest中指定的代理类，使用与main类相同的类加载器加载代理类。
     *  在main方法之前执行premain方法。被统一的安全策略(security policy)和上下文(context)管理
     * 2.如果premain(String args, Instrumentation inst)和premain(String args)同时存在时，优先使用前者。
     * 3.Instrumentation#addTransformer()方法用于添加自己定义的ClassFileTransformer，来改变class文件。
     * </pre>
     * @param agentOps 命令中的字符串参数
     * @param inst inst是运行时由JVM自动传入的Instrumentation实例，可以用于获取JVM信息。
     */
    public static void premain(String agentOps, Instrumentation inst) {
        System.out.println("=========premain方法执行========");
        System.out.println(agentOps);

        //inst.addTransformer();
    }

    public static void premain(String agentOps) {
        System.out.println("=========premain方法执行2========");
        System.out.println(agentOps);
    }
}
