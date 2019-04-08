package com.maxzuo;

import org.junit.Test;

import java.util.Arrays;
import java.util.regex.Pattern;

/**
 * 测试主类
 * Created by zfh on 2019/03/25
 */
public class MainTest {

    private static final Pattern NAME_SEPARATOR = Pattern.compile("\\s*[,]+\\s*");

    @Test
    public void test() {
        String message = "hello,world";
        String[] split = NAME_SEPARATOR.split(message);
        System.out.println(Arrays.toString(split));
    }
}
