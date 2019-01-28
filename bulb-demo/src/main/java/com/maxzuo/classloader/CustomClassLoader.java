package com.maxzuo.classloader;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * 自定义ClassLoader（双亲委派模型）
 * Created by zfh on 2019/01/26
 */
class CustomClassLoader extends ClassLoader {

    private static final String CLASSPATH = "F:\\bulb\\bulb-agent\\target\\classes\\";

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        try {
            String fileName = CLASSPATH + name.replace(".","/") + ".class";
            FileInputStream is = new FileInputStream(fileName);
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            int len;
            while ((len = is.read()) != -1) {
                bos.write(len);
            }
            byte[] bytes = bos.toByteArray();
            bos.close();
            is.close();
            return defineClass(name, bytes, 0, bytes.length);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return super.findClass(name);
    }

    public static void main (String[] args) {
        //loadClassFile();
        loadJarFile();
    }

    /** 动态加载外部class文件 */
    private static void loadClassFile () {
        try {
            CustomClassLoader customClassLoader = new CustomClassLoader();
            Class<?> aClass = Class.forName("com.maxzuo.agent.Main", true, customClassLoader);
            System.out.println("全限定类名：" + aClass.getName());
            System.out.println("类加载器：" + aClass.getClassLoader());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /** 动态加载外部jar文件 */
    private static void loadJarFile () {
        try {
            CustomClassLoader classLoader = new CustomClassLoader();
            URL urls = new URL("file:F:\\bulb\\bulb-agent\\target\\bulb-agent.jar");
            URLClassLoader urlLoader = new URLClassLoader(new URL[]{urls}, classLoader);

            Class<?> aClass = Class.forName("com.maxzuo.agent.Main", true, urlLoader);
            System.out.println("全限定名：" + aClass.getName());
            System.out.println("类的加载器：" + aClass.getClassLoader());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

