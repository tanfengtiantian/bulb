package com.maxzuo.agent;

import java.lang.instrument.Instrumentation;

/**
 * 使用探针实现服务器热部署
 * Created by zfh on 2019/01/30
 */
public class Main {

    public static void premain(String options, Instrumentation inst) {
        System.out.println("========进入premain方法============");
        System.out.println("options：" + options);
        //inst.addTransformer();
    }
}
