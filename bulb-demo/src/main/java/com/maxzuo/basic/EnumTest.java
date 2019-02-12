package com.maxzuo.basic;

/**
 * 枚举的使用
 * Created by zfh on 2019/02/12
 */
public enum EnumTest {
    INSTANCE(1, "name"),
    TEST(2, "age");

    private Integer code;

    private String name;

    EnumTest (Integer code, String name) {
        this.code = code;
        this.name = name;
    }

    public void assigment (String name) {
        this.name = name;
    }

    public void out () {
        System.out.println(name);
    }
}

class MainTest {

    public static void main(String[] args) {
        // 覆盖原始值
        EnumTest.INSTANCE.assigment("dazuo");
        // 输出：dazuo
        EnumTest.INSTANCE.out();
        // 输出：age
        EnumTest.TEST.out();
    }
}