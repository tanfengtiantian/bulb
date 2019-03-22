package com.maxzuo.easycode.day2;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zfh on 2019/03/23
 */
public class FinallyMethodTest {

    public static void main(String[] args) {
        System.out.println("test1: " + test1());
        System.out.println("test2: " + test2());
        System.out.println("test3: " + test3());
        Map<String, String> data = new HashMap<>(4);
        Map<String, String> result = test4(data);
        System.out.println("test4: " + data + ", result = " + result);
        System.out.println("test5: " + test5());
    }

    /**
     * 修改字符串后，会返回新字符串在常量池中的地址（注意：和对象引用有所区别）
     */
    private static String test1() {
        String name = "dazuo";
        try {
            throw new RuntimeException();
        } catch (Exception e) {
            return name;
        } finally {
            name = "wang";
        }
    }

    private static int test2() {
        int a = 3;
        try {
            throw new RuntimeException();
        } catch (Exception e) {
            return a;
        } finally {
            a += 1;
        }
    }

    /**
     * 对象引用传递（堆的内存地址是不变的）
     */
    private static Map<String, String> test3 () {
        Map<String, String> data = new HashMap<>();
        data.put("name", "dazuo");
        try {
            throw new RuntimeException();
        } catch (Exception e) {
            return data;
        } finally {
            data.put("name", "wang");
        }
    }

    /**
     * 引用传递
     */
    private static Map<String, String> test4(Map<String, String> data) {
        data.put("name", "dazuo");
        try {
            throw new RuntimeException();
        } catch (Exception e) {
            return data;
        } finally {
            data.put("name", "wang");
        }
    }

    /**
     * 【强制】不要在 finally 块中使用 return
     *  finally 块中的 return 返回后方法结束执行，不会再执行 try 块中的 return 语句。
     */
    private static String test5() {
        String name = "dazuo";
        try {
            throw new RuntimeException();
        } catch (Exception e) {
            return name;
        } finally {
            name = "wang";
            return name;
        }
    }
}
