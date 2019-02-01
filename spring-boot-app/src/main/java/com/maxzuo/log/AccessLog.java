package com.maxzuo.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 定时输出日志
 * Created by zfh on 2019/01/31
 */
@Component
@EnableScheduling
public class AccessLog {

    private static final Logger logger = LoggerFactory.getLogger("access");

    @Scheduled(cron = "0/5 * * * * ?")
    private void recordLog () {
        logger.debug("record Log：timestamp = {}", System.currentTimeMillis());
        logger.info("record Log：timestamp = {}", System.currentTimeMillis());
        logger.warn("record Log：timestamp = {}", System.currentTimeMillis());
        logger.error("record Log：timestamp = {}", System.currentTimeMillis());
        try {
            if (System.currentTimeMillis() > 1) {
                throw new RuntimeException("异常信息");
            }
        } catch (Exception e) {
            logger.warn("异常信息 ", e.getMessage(), e);
        }
    }
}
