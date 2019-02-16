package com.maxzuo.io;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

/**
 * 打印流
 * Created by zfh on 2019/02/16
 */
class PrintStreamTest {

    @DisplayName("标准输入流")
    @Test
    void testSystemIn() {
        // “标准”输入流。此流已打开并准备提供输入数据。通常，此流对应于键盘输入或者由主机环境或用户指定的另一个输入源。
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            System.out.println(scanner.next());
        }
    }

    @DisplayName("标准输出流")
    @Test
    void testSystemOut () {
        // “标准”输出流。此流已打开并准备接受输出数据。通常，此流对应于显示器输出或者由主机环境或用户指定的另一个输出目标。
        PrintStream out = System.out;
        out.println("hello world!");
    }

    @DisplayName("打印流")
    @Test
    void testPrintStream () throws IOException {
        File file = new File("test.txt");
        if (!file.exists()) {
            file.createNewFile();
        }
        PrintStream ps = new PrintStream(file);
        ps.println("hello world!");
        ps.println("hello print!");
        ps.close();
    }
}
