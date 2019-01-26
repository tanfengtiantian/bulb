package com.maxzuo.reflect;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;

/**
 * 自定义ClassLoader
 * Created by zfh on 2019/01/26
 */
class CustomClassLoader extends ClassLoader {

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        try {
            String fileName = "F:\\bulb\\bulb-demo\\src\\main\\java\\" + name.replace(".","/") + ".class";
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

    public static void main (String[] args) throws ClassNotFoundException {
        CustomClassLoader customClassLoader = new CustomClassLoader();
        // 委派上一级加载器加载类，若上一级加载器不能加载，则当前发起加载请求的加载器加载类
        Class<?> aClass = customClassLoader.loadClass("com.maxzuo.reflect.model.User");
        // 输出：sun.misc.Launcher$AppClassLoader@18b4aac2
        System.out.println(aClass.getClassLoader());

        // 当前加载器直接加载
        Class<?> aClass2 = customClassLoader.findClass("com.maxzuo.reflect.model.User");
        // 输出：com.maxzuo.reflect.CustomClassLoader@6ff3c5b5
        System.out.println(aClass2.getClassLoader());
    }
}

