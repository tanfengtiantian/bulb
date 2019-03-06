package com.maxzuo.nio;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.nio.charset.Charset;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;

/**
 * 字符编码
 * Created by zfh on 2019/01/23
 */
public class CharsetTest {

    @DisplayName("测试字符编码")
    @Test
    void testCharset() {
        SortedMap<String, Charset> map = Charset.availableCharsets();
        Set<Map.Entry<String, Charset>> entries = map.entrySet();
        for (Map.Entry<String, Charset> entry : entries) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
