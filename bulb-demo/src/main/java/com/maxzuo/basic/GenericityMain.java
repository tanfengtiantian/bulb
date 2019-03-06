package com.maxzuo.basic;

/**
 * 泛型类、泛型接口、泛型方法（注意：静态泛型方法不能访问类上定义的泛型）
 * Created by zfh on 2019/02/13
 */

public class GenericityMain {

    public static void main(String[] args) {
        System.out.println("******************泛型类*****************");

        new GenericityOne<Integer>().methodOne(1);
        new GenericityOne<String>().methodOne("hello world");
        new GenericityOne<Boolean>().methodOne(true);

        System.out.println("****************泛型方法****************");

        new GenericityTwo<Integer>().methodOne(1234, 1);
        new GenericityTwo<String>().methodOne("hello", "h");
        new GenericityTwo<Boolean>().methodOne(true, false);

        System.out.println("****************静态泛型方法***************");
        GenericityTwo.methodTwo(123);
        GenericityTwo.methodTwo("hello");
        GenericityTwo.methodTwo(true);

        System.out.println("****************泛型接口****************");

        new GenericityThree<Integer>() {
            @Override
            public void methodOne(Integer flag) {
                System.out.println("methodOne：" + flag);
            }
        }.methodOne(123);

        new GenericityThree<String>() {
            @Override
            public void methodOne(String flag) {
                System.out.println("methodOne：" + flag);
            }
        }.methodOne("hello");

        new GenericityThree<Boolean>() {
            @Override
            public void methodOne(Boolean flag) {
                System.out.println("methodOne：" + flag);
            }
        }.methodOne(true);
    }
}

/** 泛型类 */
class GenericityOne<T> {
    public void methodOne(T flag) {
        System.out.println("methodOne：" + flag);
    }
}

/** 泛型方法 */
class GenericityTwo<K> {

    public <T> void methodOne(T fast, K slow) {
        System.out.println("methodOne flag：" + fast);
        System.out.println("methodOne slow：" + slow);
    }

    // 静态方法不能访问类上的泛型

    public static <T> void methodTwo(T flag) {
        System.out.println("methodTwo：" + flag);
    }
}

/** 泛型接口 */
interface GenericityThree<T> {

    void methodOne(T flag);
}
