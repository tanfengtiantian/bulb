package com.maxzuo;

import org.apache.log4j.Level;
import org.apache.log4j.Priority;
import org.apache.log4j.spi.LoggingEvent;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zfh on 2019/02/01
 */
@DisplayName("测试主类")
class MainTest {

    private static final Logger logger = LoggerFactory.getLogger(MainTest.class);

    @Test
    void testLog() {
        logger.info("hello {} {}", 234, "helo");
    }

    @Test
    void testLoggingEvent () {
        final LoggingEvent event = new LoggingEvent(null, null, null, null, null);;
        Level level = event.getLevel();
        if (level.equals(Level.ERROR)) {
            String renderedMessage = event.getRenderedMessage();
        }
    }

    @Test
    void transformStream() {
        byte[] bytes = { 104, 101, 108, 108, 111, 32, 107, 97, 102, 107, 97 };
        String string = new String(bytes);
        System.out.println("string: " + string);
    }
}
