package com.daofree;

import java.io.IOException;
import java.net.*;

/**
 * @ClassName UDPSendDemo
 * @Description: UDP协议发送信息,不分客户端服务端，两端都是DatagramSocket
 * @Author DaoTianXia
 * @Date 2020-07-05-22:13
 * @Version V1.0
 **/
public class UDPSendDemo {
    public static void main(String[] args) throws IOException {
        // 发送端对象
        DatagramSocket ds = new DatagramSocket();
        // 准备数据
        byte[] bytes = "hello,this is udp".getBytes();
        System.out.println(bytes);
        int length = bytes.length;
        // 广播地址发送
        InetAddress ia = InetAddress.getByName("192.168.0.255");
        int port = 10086;
        // 创造数据包
        DatagramPacket dp = new DatagramPacket(bytes, length, ia, port);
        // 发送数据包
        ds.send(dp);
        // 释放资源
        ds.close();
    }
}
