package com.maxzuo.log;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 记录访问日志（AOP）
 * Created by zfh on 2018/09/19
 */
@Aspect
@Component
public class AccessLog {

    private static final Logger logger = LoggerFactory.getLogger(AccessLog.class);

    public AccessLog() {
        logger.info("AccessLog 类初始化");
    }

    @Before("execution(* com.maxzuo.service..*(..))")
    public void recordAccessLog() {
        logger.info("AccessLog#recordAccessLog 前置通知");
    }

    @After("execution(* com.maxzuo.service..*(..))")
    public void recordAccessLogAfter() {
        logger.info("AccessLog#recordAccessLogAfter 后置通知");
    }
}
