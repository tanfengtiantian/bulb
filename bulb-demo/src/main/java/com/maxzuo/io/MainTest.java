package com.maxzuo.io;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.*;

/**
 * IO流（文件操作、字符流、字节流、流的转换）
 * Created by zfh on 2019/01/23
 */
class MainTest {

    @DisplayName("测试操作文件：File")
    @Test
    void testOperatorFile() throws IOException {
        // 当前命令的操作路径：F:\bulb\bulb-demo
        File file = new File("spring.png");
        System.out.println("文件是否存在" + file.exists());
        boolean newFile = file.createNewFile();
        System.out.println("如果文件不存在，则创建空文件：" + newFile);
        File tempFileStatus = File.createTempFile("demo", ".txt");
        System.out.println("使用给定的前缀和后缀创建临时文件: " + tempFileStatus.getPath());
        System.out.println("文件名：" + file.getName());
        System.out.println("文件可读状态：" + file.canRead());
        System.out.println("绝对路径名形式：" + file.getAbsoluteFile());
        System.out.println("绝对路径字符串：" + file.getAbsolutePath());
        System.out.println("路径名字符串：：" + file.getPath());
        System.out.println("isFile：" + file.isFile());
        System.out.println("isDirectory：" + file.isDirectory());
        System.out.println("文件的长度：" + file.length());
        boolean mkdirStatus = file.mkdir();
        System.out.println("创建抽象路径名指定的目录：" + mkdirStatus);
        boolean mkdirsStatus = file.mkdirs();
        System.out.println("创建抽象路径名指定的目录，包括所有必须但不存在的父目录：" + mkdirsStatus);
        //boolean deleteStatus = file.delete();
        //System.out.println("文件删除状态：" + deleteStatus);
    }

    @DisplayName("测试字符流：FileWriter和FileReader")
    @Test
    void testFileReaderFileWriterFile() throws IOException {
        File file = new File("demo.txt");
        if (!file.exists()) {
            file.createNewFile();
        }
        FileWriter fileWriter = new FileWriter(file);
        System.out.println("Encoding: " + fileWriter.getEncoding());
        // 将指定的字符串追加到写入器
        fileWriter.append("future\r\n");
        fileWriter.write("hello world");
        fileWriter.flush();
        fileWriter.close();

        FileReader fileReader = new FileReader(file);
        // 读取单个字符
        System.out.println((char) fileReader.read());
        // 读取一个字符数组
        char[] chars = new char[2];
        System.out.println("读取的字符长度：" + fileReader.read(chars));
        System.out.println("char[] = " + new String(chars));
        fileReader.close();
    }

    @DisplayName("测试字节流：FileInputStream 和 FileOutputStream")
    @Test
    void testFileInputStreamAndOutputStream () throws IOException {
        File file = new File("demo.txt");
        if (!file.exists()) {
            file.createNewFile();
        }
        FileInputStream is = new FileInputStream(file);
        System.out.println("读取一个数据字节：" + (char) is.read());
        byte[] bytes = new byte[2];
        System.out.println("读取字节数组的长度：" + is.read(bytes));
        System.out.println("读取的字符：" + new String(bytes));
        is.close();

        // 字节输出流写入字符到文件
        FileOutputStream os = new FileOutputStream(file, true);
        String str = "\r\ndazuo";
        os.write(str.getBytes());
        os.flush();
        os.close();
    }

    @DisplayName("测试字符流缓冲区：BufferedReader/BufferedWriter")
    @Test
    void testBufferReader () throws IOException {
        File file = new File("demo.txt");
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);

        // 指定Buffer中一个特定的position，之后可以通过调用reset()方法恢复到这个position
        if (br.markSupported()) {
            br.mark(0);
            br.reset();
        }
        FileWriter fw = new FileWriter(file);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.close();
        fw.close();
        br.close();
        fr.close();
    }

    @DisplayName("测试字节流缓冲区：BufferedInputStream和BufferedOutputStream")
    @Test
    void testBufferInputStream () throws IOException {
        File file = new File("spring.png");
        FileInputStream is = new FileInputStream(file);
        BufferedInputStream bis = new BufferedInputStream(is);

        // 如果文件不存在，会创建新文件
        FileOutputStream os = new FileOutputStream("spring2.png");
        BufferedOutputStream bos = new BufferedOutputStream(os);

        byte[] bytes = new byte[1024];
        int charCount;
        // 读取单个字符，-1代表已达到流的末尾
        while ((charCount = bis.read(bytes)) != -1) {
            bos.write(bytes, 0, charCount);
        }
        bos.close();
        os.close();
        bis.close();
        is.close();
    }

    @DisplayName("字节流和字符串的转换：InputStreamReader和 OutputStreamWriter")
    @Test
    void convertStream() throws IOException {
        File file = new File("demo.txt");
        FileInputStream is = new FileInputStream(file);
        // 字节流转换为字符流
        InputStreamReader inputStreamReader = new InputStreamReader(is);
        // 读取一个字符
        char[] chars = new char[2];
        System.out.println("读取的字符长度：" + inputStreamReader.read(chars));
        System.out.println("读取的字符：" + new String(chars));
        inputStreamReader.close();
        is.close();

        // 字符流转换为字节流
        FileOutputStream os = new FileOutputStream(file, true);
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(os);
        outputStreamWriter.write("\r\n大左");

        outputStreamWriter.flush();
        outputStreamWriter.close();
        os.close();
    }
}
