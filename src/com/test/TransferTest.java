package com.test;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class TransferTest {

    public static void main(String[] args) throws IOException {
        byteBuffRead();
    }

    public static void byteBuffRead() throws IOException {
        //=========== 读 ===========
        //拿到文件
        File file = new File("d:\\file\\123.txt");
        FileInputStream inputStream = new FileInputStream(file);
        //创建管道，把文件放入通道
        FileChannel fileChannel = inputStream.getChannel();
        //创建Buffer
        ByteBuffer buffer = ByteBuffer.allocate((int)file.length());
        //从通道读数据放入缓冲区
        fileChannel.read(buffer);

        //=========== 反转读写模式 ===========
        buffer.flip();

        //=========== 写 ===========
        //创建文件
        FileOutputStream outputStream = new FileOutputStream("d:\\file\\456.txt");
        //创建Channel2，把文件放入通道
        FileChannel fileChannel2 = outputStream.getChannel();
        //把Buffer内容放入Channel2
        fileChannel2.write(buffer);

        //=========== 关闭与清除 ===========
        fileChannel2.close();
        outputStream.close();
        fileChannel.close();
        inputStream.close();
        buffer.clear();
    }

    public static void transferFile() throws IOException {
        //=========== 创建读通道 ===========
        //拿到文件
        File file = new File("d:\\file\\123.txt");
        FileInputStream inputStream = new FileInputStream(file);
        //创建管道，把文件放入通道
        FileChannel fileChannel = inputStream.getChannel();


        //=========== 创建写通道 ===========
        //创建文件
        FileOutputStream outputStream = new FileOutputStream("d:\\file\\456.txt");
        //创建Channel2，把文件放入通道
        FileChannel fileChannel2 = outputStream.getChannel();

        //=========== transferFrom从目标通道复制到当前通道 ===========
//        fileChannel2.transferFrom(fileChannel,0,fileChannel.size());

        //=========== transferTo从当前通道复制到目标通道 ===========
        fileChannel.transferTo(0, fileChannel.size(), fileChannel2);

        //=========== 关闭与清除 ===========
        fileChannel2.close();
        outputStream.close();
        fileChannel.close();
        inputStream.close();
    }
}
