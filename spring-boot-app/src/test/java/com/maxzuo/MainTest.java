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

    private static final Logger logger = LoggerFactory.getLogger(MainTest.class);

    @Test
    void testLog() {
        logger.info("hello");
    }

    @Test
    void transformStream() {
        byte[] bytes = { 104, 101, 108, 108, 111, 32, 107, 97, 102, 107, 97 };
        String string = new String(bytes);
        System.out.println("string: " + string);
    }
}
