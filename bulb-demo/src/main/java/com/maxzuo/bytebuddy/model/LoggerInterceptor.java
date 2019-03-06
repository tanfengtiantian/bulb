package com.maxzuo.bytebuddy.model;

import net.bytebuddy.implementation.bind.annotation.SuperCall;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
 * Created by zfh on 2019/01/29
 */
public class LoggerInterceptor {

    public static List<String> log(@SuperCall Callable<List<String>> zuper) throws Exception {
        System.out.println("Calling database");
        try {
            TimeUnit.SECONDS.sleep(3);
            List<String> call = zuper.call();
            System.out.println("calling: " + call);
            return call;
        } finally {
            System.out.println("Returned from database");
        }
    }
}
