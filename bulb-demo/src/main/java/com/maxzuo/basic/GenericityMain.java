package com.maxzuo.basic;

/**
 * 泛型类、泛型接口、泛型方法
 * <p>
 * Created by zfh on 2019/02/13
 */
public class GenericityMain {

    public static void main(String[] args) {
        System.out.println("******************泛型类*****************");

        new GenericityOne<Integer>().methodOne(1);
        new GenericityOne<String>().methodOne("hello world");
        new GenericityOne<Boolean>().methodOne(true);

        System.out.println("****************泛型方法****************");
        new GenericityTwo<Integer>().methodOne(1);
        new GenericityTwo<Integer>().methodTwo("name");
        GenericityTwo.methodThree(123);

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

/**
 * 泛型类
 */
class GenericityOne<T> {
    void methodOne(T flag) {
        System.out.println("methodOne：" + flag);
    }
}

/**
 * 泛型方法
 */
class GenericityTwo<K> {

    /**
     * 使用类上的泛型
     */
    void methodOne(K msg) {
        System.out.println("methodOne msg：" + msg);
    }

    /**
     * 实例调用；入参决定类型
     */
    <L> void methodTwo(L msg) {
        System.out.println("methodTwo: " + msg);
    }

    /**
     * 静态方法不能访问类上的泛型；静态调用，入参决定类型
     */
    public static <T> void methodThree(T msg) {
        System.out.println("methodThree：" + msg);
    }
}

/**
 * 泛型接口
 */
interface GenericityThree<T> {

    void methodOne(T flag);
}
