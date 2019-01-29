package com.maxzuo.bytebuddy.model;

import net.bytebuddy.implementation.bind.annotation.Argument;

/**
 * Created by zfh on 2019/01/29
 */
public class Target {

    public Target () {
        System.out.println("init target constructor");
    }

    public String hello (String name) {
        return "init intecept " + name;
    }

    public static String print (@Argument(1) String desc, @Argument(0) Integer id) {
        return "id=" + id + ", desc=" + desc;
    }

    public static String intecept (String name) {
        return "intecept " + name;
    }

    public static String intecept (int i) {
        return Integer.toString(i);
    }

    public static String intecept (Object o) {
        return "Object " + o.toString();
    }
}
