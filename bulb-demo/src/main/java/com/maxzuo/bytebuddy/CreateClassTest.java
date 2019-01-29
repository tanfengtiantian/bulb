package com.maxzuo.bytebuddy;

import com.maxzuo.bytebuddy.model.Fast;
import com.maxzuo.bytebuddy.model.Slow;
import net.bytebuddy.ByteBuddy;
import net.bytebuddy.agent.ByteBuddyAgent;
import net.bytebuddy.dynamic.ClassFileLocator;
import net.bytebuddy.dynamic.DynamicType;
import net.bytebuddy.dynamic.loading.ClassLoadingStrategy;
import net.bytebuddy.dynamic.loading.ClassReloadingStrategy;
import net.bytebuddy.pool.TypePool;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.Vector;

/**
 * 使用ByteBuddy创建类和加载类
 * Created by zfh on 2019/01/28
 */
@DisplayName("创建类和加载类")
class CreateClassTest {

    @DisplayName("创建一个类")
    @Test
    void testCreateClass () {
        /*
            创建一个继承至 Object 类型的类；
              1.默认命名策略下，它基于动态类型的超类名称来随机生成类名。这些类型名称将会冠以 net.bytebuddy.renamed 的前缀。
              2.按提供的名称命名动态类型；那么生成的名称将会类似于com.maxzuo.com.bytebuddy.Bean1376491271，这里的数字是随机的。
         */
        DynamicType.Unloaded<Object> dynamicType = new ByteBuddy().subclass(Object.class).make();
        DynamicType.Unloaded<Object> dynamicType2 = new ByteBuddy().subclass(Object.class).name("com.maxzuo.com.bytebuddy.Bean").make();
        /*
            当重定义一个类时，Byte Buddy可以对一个已有的类添加属性和方法，或者删除已经存在的方法实现。
            如果使用其他的方法实现替换已经存在的方法实现，则原来存在的方法实现就会消失。
         */
        DynamicType.Unloaded<Object> dynamicType3 = new ByteBuddy().redefine(Object.class).make();
        /*
            当重定基底一个类时，Byte Buddy 保存基底类所有方法的实现。当 Byte Buddy 如执行类型重定义时，它将所有这些方法实现复制
            到具有兼容签名的重新命名的私有方法中，而不是抛弃重写的方法
         */
        DynamicType.Unloaded<Object> dynamicType4 = new ByteBuddy().rebase(Object.class).make();
    }

    @DisplayName("加载自定义类")
    @Test
    void testLoadClass () {
        // 加载自定义创建的类
        Class<?> aClass = new ByteBuddy()
                .subclass(Object.class)
                .defineField("name", String.class)
                .make()
                .load(getClass().getClassLoader(), ClassLoadingStrategy.Default.WRAPPER)
                .getLoaded();
        try {
            System.out.println("自定义类（全限定类名）：" + aClass.getName());
            System.out.println("自定义类的属性：" + aClass.getDeclaredField("name").getName());
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    @DisplayName("重新加载类")
    @Test
    void testReloadClass () {
        // 安装代理，从代理中加载类型
        ByteBuddyAgent.install();
        Fast fast = new Fast();
        System.out.println("old result：" + fast.m());
        new ByteBuddy()
                .redefine(Slow.class)
                .name(Fast.class.getName())
                .make()
                .load(ClassLoader.getSystemClassLoader(), ClassReloadingStrategy.fromInstalledAgent());
        System.out.println("new result：" + fast.m());
    }

    @DisplayName("操作没有加载的类")
    @Test
    void testNotLoadClass () {
        TypePool typePool = TypePool.Default.ofClassPath();
        new ByteBuddy()
                .redefine(typePool.describe("com.maxzuo.bytebuddy.model.Fast").resolve(), ClassFileLocator.ForClassLoader.ofClassPath())
                .defineField("age", String.class)
                .make()
                .load(ClassLoader.getSystemClassLoader());
        try {
            System.out.println("字段名：" + Fast.class.getDeclaredField("age"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

