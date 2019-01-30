package com.maxzuo.bytebuddy.model;

import net.bytebuddy.implementation.bind.annotation.AllArguments;
import net.bytebuddy.implementation.bind.annotation.Argument;
import net.bytebuddy.implementation.bind.annotation.This;

import java.util.Arrays;
import java.util.List;

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

    //public static String print (@Argument(1) String title, @Argument(0) String name) {
    //    return "title: " + title + ", name:" + name;
    //}

    //public static String print2 (@AllArguments String[] array) {
    //    System.out.println("array: " + Arrays.toString(array));
    //    return "print2";
    //}

    public static String print3 (@This Object object) {
        System.out.println("object: " + object);
        return "print3";
    }

    //public static String intecept (String name) {
    //    return "intecept " + name;
    //}
    //
    //public static String intecept (int i) {
    //    return Integer.toString(i);
    //}
    //
    //public static String intecept (Object o) {
    //    return "Object " + o.toString();
    //}
}
