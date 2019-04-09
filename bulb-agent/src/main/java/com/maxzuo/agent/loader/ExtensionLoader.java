package com.maxzuo.agent.loader;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.List;

/**
 * SPI 类加载器
 * <p>
 * Created by zfh on 2019/04/04
 */
public class ExtensionLoader {

    /**
     * 通过全限定类名加载类
     */
    public static Class<?> getExtension(String className) {
        final List<URL> jarURLList = new ArrayList<>();

        String agentLibPath = "F:\\bulb\\bulb-agent\\target\\lib";
        File agentDirectory = new File(agentLibPath);
        File[] findJarList = agentDirectory.listFiles();
        if (findJarList != null) {
            for (File file : findJarList) {
                URI uri = file.toURI();
                try {
                    jarURLList.add(uri.toURL());
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
            }
        }
        URLClassLoader urlLoader = new URLClassLoader(jarURLList.toArray(new URL[0]), null);

        try {
            return urlLoader.loadClass(className);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
