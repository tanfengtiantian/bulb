package com.maxzuo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.util.SafeEncoder;

import java.util.Arrays;

/**
 * Created by zfh on 2019/02/01
 */
@DisplayName("测试主类")
class MainTest {

    private static final Logger logger = LoggerFactory.getLogger("access");

    @Test
    void testLog() {
        byte[] hellos = SafeEncoder.encode("hello");
        System.out.println(Arrays.toString(hellos));
    }

    @Test
    void transformStream() {
        byte[] bytes = { 104, 101, 108, 108, 111, 32, 107, 97, 102, 107, 97 };
        String string = new String(bytes);
        System.out.println("string: " + string);
    }
}
