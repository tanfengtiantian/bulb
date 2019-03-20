package com.maxzuo.bytebuddy.model;

import net.bytebuddy.implementation.bind.annotation.RuntimeType;
import net.bytebuddy.implementation.bind.annotation.SuperCall;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
 * Created by zfh on 2019/01/29
 */
public class LoggerInterceptor {

    @RuntimeType
    public Object intercept(@SuperCall Callable<List<String>> zuper) throws Exception {
        System.out.println("Calling database");
        TimeUnit.SECONDS.sleep(1);
        List<String> result = zuper.call();
        System.out.println("result: " + result);
        // 修改原方法的返回值
        return result.subList(0, 2);
    }
}
