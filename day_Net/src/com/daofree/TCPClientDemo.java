package com.daofree;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @ClassName TCPClientDemo
 * @Description: TCP发送数据
 * @Author DaoTianXia
 * @Date 2020-07-06-22:31
 * @Version V1.0
 **/
public class TCPClientDemo {
    public static void main(String[] args) throws IOException {
//        Socket socket = new Socket(InetAddress.getByName("192.168.0.104"), 9999);

        // 一定要先开服务器
        // java.net.ConnectException: Connection refused: connect
        Socket socket = new Socket("192.168.0.104", 9999);
        // 通道内的输出流
        OutputStream os = socket.getOutputStream();
        // 写数据
        os.write("hello, this is tcp!".getBytes());

        String hostAddress = socket.getInetAddress().getHostAddress();

        // 获取输入流，读数据
        InputStream is = socket.getInputStream();
        byte[] bytes = new byte[1024];
        // 阻塞
        int len = is.read(bytes);
        String s1 = new String(bytes, 0, len);
        System.out.println("服务端来信:" + s1);
        // 释放资源
        socket.close();
    }
}
