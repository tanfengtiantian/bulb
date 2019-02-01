package com.maxzuo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by zfh on 2019/02/01
 */
@DisplayName("测试主类")
class MainTest {

    private static final Logger logger = LoggerFactory.getLogger("access");

    @Test
    void testLog () {
        logger.debug("hello world");
        logger.info("hello world");
        logger.warn("hello wrold");
        logger.error("hello world");
        try {
            if (System.currentTimeMillis() > 1) {
                throw new RuntimeException("异常信息");
            }
        } catch (Exception e) {
            logger.warn("异常信息 ", e.getMessage(), e);
        }
    }

}
