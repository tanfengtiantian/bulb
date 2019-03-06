package com.maxzuo.nio;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * JDK7 NIO新增特性Paths和Path
 * Created by zfh on 2019/01/24
 */
class PathsTest {

    @DisplayName("Paths常用方法")
    @Test
    void testPaths() {
        // 提供的 get() 方法用来获取 Path 对象：
        Path path = Paths.get("spring.png");
        System.out.println("path: " + path);
    }

    @DisplayName("Path常用方法")
    @Test
    void testPathCommonMethod() {
        Path path = Paths.get("spring.png");
        Path path2 = Paths.get("F:\\bulb\\bulb-demo\\spring.png");
        // 输出：false
        System.out.println("是否是绝对路径：" + path.isAbsolute());
        // 输出：true
        System.out.println("是否是绝对路径：" + path2.isAbsolute());
        // 输出：true
        System.out.println("判断是以xxx路径结束：" + path.endsWith("spring.png"));
        // 输出：false
        System.out.println("判断是以xxx路径结束：" + path.endsWith("png"));
        // 输出：true
        System.out.println("判断是以xxx路径开始：" + path.startsWith("spring.png"));
        // 输出：true
        System.out.println("判断是以xxx路径开始：" + path2.startsWith("F:\\"));
        // 输出：false
        System.out.println("判断是否是绝对路径：" + path.isAbsolute());
        // 输出：true
        System.out.println("判断是否是绝对路径：" + path2.isAbsolute());
        // 两者输出：spring.png
        System.out.println("文件名：" + path.getFileName());
        System.out.println("文件名：" + path2.getFileName());
        // 作为绝对路径返回调用Path对象
        Path newPath = path.toAbsolutePath();
        System.out.println("是否是绝对路径：" + newPath.isAbsolute());
        // 输出：spring.png
        System.out.println("toString: " + path.toString());
        // 输出：F:\bulb\bulb-demo\spring.png
        System.out.println("toString: " + path2.toString());
        // 输出：null
        System.out.println("对象的根路径：" + path.getRoot());
        // 输出：F:\
        System.out.println("对象的根路径：" + path2.getRoot());
        // 输出：null
        System.out.println("返回Path对象包含整个路径，不包含Path对象指定的文件路径：" + path.getParent());
        // 输出：F:\bulb\bulb-demo
        System.out.println("返回Path对象包含整个路径，不包含Path对象指定的文件路径：" + path2.getParent());
        // 输出：1
        System.out.println("返回Path根目录后面元素的数量: " + path.getNameCount());
        // 输出：3
        System.out.println("返回Path根目录后面元素的数量: " + path2.getNameCount());
        // 输出：spring.png，上面的数量是界限，超出界限会报错
        System.out.println("返回指定索引位置的路径名称：" + path.getName(0));
        // 输出：bulb，F:\bulb\bulb-demo\spring.png（bulb 对应 0，bulb-demo对应 1，spring.png 对应 2）
        System.out.println("返回指定索引位置的路径名称：" + path2.getName(0));
        // 将相对路径解析为绝对路径（相当于将path2的父路径，当成目标参数的父路径，拼接得到新的路径）
        Path resolvePath = path2.getParent().resolve("spring2.png");
        System.out.println("resolvePath: " + resolvePath);
    }
}
