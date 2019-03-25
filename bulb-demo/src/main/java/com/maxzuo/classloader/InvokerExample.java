package com.maxzuo.classloader;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileFilter;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 调用类的加载器
 * Created by zfh on 2019/02/23
 */
class InvokerExample {

    @DisplayName("线程上下文类加载器")
    @Test
    void testThreadContextClassLoader() {
        // 线程上下文类加载器破坏了“双亲委派模型”，可以在执行线程中抛弃双亲委派加载链模式，使程序可以逆向使用类加载器。
        // 示例：父级类加载器加载的类 调用 子级类加载器加载的类
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        System.out.println(contextClassLoader);
    }

    @DisplayName("测试不同类加载器加载类")
    @Test
    void testMultipleClassFile() {
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
    void testLoadClassFile() {
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
    void testLoadJarFile() {
        try {
            URL urls = new URL("file:F:\\bulb\\bulb-agent\\target\\bulb-agent.jar");
            URLClassLoader urlLoader = new URLClassLoader(new URL[] { urls });
            Class<?> aClass = urlLoader.loadClass("com.maxzuo.agent.PerfMonAgent");
            System.out.println("类的加载器：" + aClass.getClassLoader());
            // 关闭，释放资源，此后将不能使用urlLoader类加载新类，但是已经加载的class不受影响。
            urlLoader.close();

            // 可以加载
            urlLoader.loadClass("com.maxzuo.agent.PerfMonAgent");
            // 无法加载 java.lang.ClassNotFoundException
            urlLoader.loadClass("com.maxzuo.agent.utils.FileUtils");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @DisplayName("加载引用的Slf4j")
    @Test
    void testLoadReferenceClass() {
        try {
            CustomClassLoader customClassLoader = new CustomClassLoader();
            Class<?> aClass = Class.forName("com.maxzuo.agent.model.Monday", true, customClassLoader);
            Object o = aClass.getConstructor(String.class).newInstance("123");
            Object result = aClass.getMethod("getLogger").invoke(o);

            // 输出：AppClassLoader
            System.out.println(result.getClass().getClassLoader());
            // 输出：true，双亲委派，由AppClassLoader优先尝试加载
            System.out.println(this.getClass().getClassLoader() == result.getClass().getClassLoader());
            // TODO: 思考URLClassLoader加载？
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @DisplayName("加载同包下的引用类")
    @Test
    void testLoadPackageClass() {
        try {
            CustomClassLoader customClassLoader = new CustomClassLoader();
            Class<?> aClass = Class.forName("com.maxzuo.agent.model.Monday", true, customClassLoader);
            Object o = aClass.getConstructor(String.class).newInstance("123");
            Object targetObject = aClass.getDeclaredMethod("getThuesday").invoke(o);

            // 输出：CustomClassLoader
            // 原理：双亲委派，AppClassLoader优先尝试加载，若无法加载，再由CustomClassLoader进行加载
            System.out.println("classLoader: " + targetObject.getClass().getClassLoader());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @DisplayName("通过UrlClassLoader加载引用的Slf4j")
    @Test
    void testUrlClassLoader() {
        try {
            String agentLibPath = "F:\\bulb\\bulb-agent\\target\\lib";
            List<URL> urls = resolveLib(agentLibPath);
            URLClassLoader urlLoader = new URLClassLoader(urls.toArray(new URL[0]), this.getClass().getClassLoader());
            Class<?> aClass = urlLoader.loadClass("com.maxzuo.agent.model.Monday");
            Object o = aClass.getConstructor(String.class).newInstance("123");
            Object targetObject = aClass.getDeclaredMethod("getLogger").invoke(o);

            // 输出：AppClassLoader
            System.out.println("类的加载器：" + targetObject.getClass().getClassLoader());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 解析lib目录，获取所有的jar
     */
    private List<URL> resolveLib(String agentLibPath) {
        File libDir = new File(agentLibPath);
        if (checkDirectory(libDir)) {
            return Collections.emptyList();
        }
        final List<URL> jarURLList = new ArrayList<>();

        final File[] findJarList = findJar(libDir);
        if (findJarList != null) {
            for (File file : findJarList) {
                URL url = toURI(file);
                if (url != null) {
                    jarURLList.add(url);
                }
            }
        }

        URL agentDirUri = toURI(new File(agentLibPath));
        if (agentDirUri != null) {
            jarURLList.add(agentDirUri);
        }
        return jarURLList;
    }

    /**
     * 检查目录
     */
    private boolean checkDirectory(File file) {
        if (!file.exists()) {
            System.out.println(file + " not found");
            return true;
        }
        if (!file.isDirectory()) {
            System.out.println(file + " is not a directory");
            return true;
        }
        return false;
    }

    private URL toURI(File file) {
        URI uri = file.toURI();
        try {
            return uri.toURL();
        } catch (MalformedURLException e) {
            System.out.println(file.getName() + ".toURL() failed.");
            return null;
        }
    }

    /**
     * 找到Jar文件
     */
    private File[] findJar(File libDir) {
        return libDir.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                String path = pathname.getName();
                for (String extension : getDefaultFileExtensionList()) {
                    if (path.lastIndexOf("." + extension) != -1) {
                        return true;
                    }
                }
                return false;
            }
        });
    }

    /**
     * 文件扩展名
     */
    private List<String> getDefaultFileExtensionList() {
        List<String> extensionList = new ArrayList<>(3);
        extensionList.add("jar");
        extensionList.add("xml");
        extensionList.add("properties");
        return extensionList;
    }
}
