package com.maxzuo.easycode.day3.pojo;

/**
 * Protected权限修饰符测试
 * Created by zfh on 2019/03/22
 */
public class Employee {

    private String  name;

    private Integer age;

    public Employee(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    protected String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }
}
