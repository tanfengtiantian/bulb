package com.maxzuo.easycode.day3;

/**
 * 测试权限修饰
 * Created by zfh on 2019/03/22
 */
public class Boss {

    public static void main(String[] args) {
        Engineer engineer = new Engineer("dazuo", 23, "development");
        System.out.println("age: " + engineer.getAge());
        System.out.println("position: " + engineer.getPosition());

        // getName()方法使用了protected修饰；因此只能在子类或同包中访问
        // 此时如果enginner没有 重写 父类Employee中的getName方法，那么调用的是父类中的方法。因此无法调用
        System.out.println(engineer.getName());
    }
}
