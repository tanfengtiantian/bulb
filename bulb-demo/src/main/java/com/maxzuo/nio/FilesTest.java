package com.maxzuo.nio;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Files工具类的使用
 * Created by zfh on 2019/01/24
 */
class FilesTest {

    @DisplayName("Files常用方法")
    @Test
    void testFilesCommonMethod () throws IOException {
        // 文件复制，成功后，返回拷贝的目标路径（如果文件已存在，会报错）
        Path copyPath = Files.copy(Paths.get("spring.png"), Paths.get("spring2.png"));
        System.out.println("copyPath: " + copyPath);
        // 删除文件或目录
        Files.delete(copyPath);
        // Files.deleteIfExists()

        if (Files.exists(Paths.get("spring.png"))) {
            // 创建一个文件
            Path newFilePath = Files.createFile(Paths.get("spring2.png"));
            Files.delete(newFilePath);
        }
        // 创建一个目录
        if (!Files.exists(Paths.get("demo"))) {
            Path newDirectory = Files.createDirectory(Paths.get("demo"));
            Files.delete(newDirectory);
        }
        long size = Files.size(Paths.get("spring.png"));
        System.out.println("指定文件的大小：" + size + " byte（字节）");

        // 移动文件
        Path copyFilePath = Files.copy(Paths.get("demo.txt"), Paths.get("demo2.txt"));
        Path moveFilePath = Files.move(copyFilePath, Paths.get("src/demo3.txt"));
        System.out.println("moveFilePath: " + moveFilePath);
        Files.delete(moveFilePath);
    }
}
