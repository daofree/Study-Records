package com.daofree;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @ClassName TCPServerDemo
 * @Description: TCP接收数据,服务端需要监听客户端，并返回对应的Socket对象，
 *               服务端自己没有获取输入流方法。
 * @Author DaoTianXia
 * @Date 2020-07-06-22:47
 * @Version V1.0
 **/
public class TCPServerDemo {
    public static void main(String[] args) throws IOException {
        // 创建接收端Socket对象
        ServerSocket ss = new ServerSocket(9999);
        // 监听客户端，并返回对应的Socket对象--客户端
        // 侦听并接受到此套接字的连接---阻塞式方法
        Socket s = ss.accept();

        String hostAddress = s.getInetAddress().getHostAddress();
        // 获取输入流，读数据
        InputStream is = s.getInputStream();
        byte[] bytes = new byte[1024];
        // 阻塞
        int len = is.read(bytes);
        String s1 = new String(bytes, 0, len);
        System.out.println(hostAddress + "-发来了-"+ s1);

        // 服务端反馈
        OutputStream outputStream = s.getOutputStream();
        outputStream.write("数据已收到".getBytes());
        // 关闭客户端
        s.close();

        // 服务端不能关
        // ss.close();
    }
}
