package com.maxzuo.reflect.model;

import java.io.Serializable;

/**
 * Created by zfh on 2019/01/26
 */
@Token("hello user")
public class User {

    private static final long serialVersionUID = 5800599219375047135L;
    private Integer id;

    private String name;

    private Integer age;

    public User() {
    }

    public User(Integer id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    @Token("hello method")
    public String getParam (String param) {
        return param + " dazuo";
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public static class Goods {}

    public class Order {}

    public String message;

    public static Integer code;
}
