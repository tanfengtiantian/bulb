package com.maxzuo.classloader;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.net.URL;
import java.net.URLClassLoader;

/**
 * 调用类的加载器
 * Created by zfh on 2019/02/23
 */
class InvokerExample {

    @DisplayName("线程上下文类加载器")
    @Test
    void testThreadContextClassLoader () {
        // 线程上下文类加载器破坏了“双亲委派模型”，可以在执行线程中抛弃双亲委派加载链模式，使程序可以逆向使用类加载器。
        // 示例：父级类加载器加载的类 调用 子级类加载器加载的类
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        System.out.println(contextClassLoader);
    }

    @DisplayName("测试不同类加载器加载类")
    @Test
    void testMultipleClassFile () {
        try {
            CustomClassLoader customClassLoader = new CustomClassLoader();
            Class<?> aClass = Class.forName("com.maxzuo.agent.PerfMonAgent", true, customClassLoader);
            Class<?> aClass1 = customClassLoader.loadClass("com.maxzuo.agent.PerfMonAgent");
            // 输出：true
            System.out.println(aClass == aClass1);

            CustomClassLoader customClassLoader2 = new CustomClassLoader();
            Class<?> aClass2 = Class.forName("com.maxzuo.agent.PerfMonAgent", true, customClassLoader2);
            // 输出：false
            System.out.println(aClass == aClass2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @DisplayName("动态加载外部class文件")
    @Test
    void testLoadClassFile () {
        try {
            /*
                PerfMonAgent类的加载过程：
                   1.启动JVM，加载主类Invoker，询问双亲加载Invoker类，最后由Launcher$AppClassLoader完成加载。
                   2.执行Class.forName加载PerfMonAgent类，询问双亲，双亲都无法找到类。最后由自定义类加载器完成加载。
             */
            CustomClassLoader customClassLoader = new CustomClassLoader();
            Class<?> aClass = Class.forName("com.maxzuo.agent.PerfMonAgent", true, customClassLoader);
            System.out.println("加载Invoker类的类加载器：" + InvokerExample.class.getClassLoader());
            System.out.println("加载PerfMonAgent类的类加载器：" + aClass.getClassLoader());

            /// 调用Class.forName，最终类的加载是由类加载器完成
            Class<?> aClass1 = customClassLoader.loadClass("com.maxzuo.agent.PerfMonAgent");
            System.out.println(aClass1.getClassLoader());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 动态加载外部jar文件
     * <pre>
     *  1.ClassLoader只能加载classpath下面的类，而URLClassLoader可以加载任意路径下的类。
     *  2.URLClassLoader提供了这个功能，它让我们可以通过以下几种方式进行加载：
     *    文件: (从文件系统目录加载)
     *    jar包: (从Jar包进行加载)
     *    Http: (从远程的Http服务进行加载)
     * </pre>
     */
    @DisplayName("动态加载外部jar文件")
    @Test
    void testLoadJarFile () {
        try {
            URL urls = new URL("file:F:\\bulb\\bulb-agent\\target\\bulb-agent.jar");
            URLClassLoader urlLoader = new URLClassLoader(new URL[]{urls});
            Class<?> aClass = urlLoader.loadClass("com.maxzuo.agent.PerfMonAgent");
            System.out.println("类的加载器：" + aClass.getClassLoader());
            // 关闭，释放资源，此后将不能使用urlLoader类加载新类，但是已经加载的class不受影响。
            urlLoader.close();

            // 可以加载
            urlLoader.loadClass("com.maxzuo.agent.PerfMonAgent");
            // 无法加载 java.lang.ClassNotFoundException
            urlLoader.loadClass("com.maxzuo.agent.FileUtils");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
