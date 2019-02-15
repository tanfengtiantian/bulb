package com.maxzuo.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 定时任务
 * Created by zfh on 2019/02/15
 */
@Component
@EnableScheduling
public class RecordLog {

    private static final Logger logger = LoggerFactory.getLogger("access");

    /** 日志打印 */
    @Scheduled(cron = "0/3 * * * * ?")
    private void recordLogToFile () {
        try {
            if (System.currentTimeMillis() > 1) {
                throw new RuntimeException();
            }
        } catch (Exception e) {
            logger.error("日志打印异常：", e);
        }
    }

    /** 标准输出 */
    @Scheduled(cron = "0/7 * * * * ?")
    private void recordLogToStdout () {
        try {
            if (System.currentTimeMillis() > 1) {
                throw new RuntimeException("标准输出异常");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
