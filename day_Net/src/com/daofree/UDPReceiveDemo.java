package com.daofree;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * @ClassName UDPReceiveDemo
 * @Description: UDP协议接收信息,不分客户端服务端，两端都是DatagramSocket
 * @Author DaoTianXia
 * @Date 2020-07-05-22:28
 * @Version V1.0
 **/
public class UDPReceiveDemo {
    public static void main(String[] args) throws IOException {
        // 发送端对象
        DatagramSocket ds = new DatagramSocket(10086);

        // 创造数据包
        byte[] bytes = new byte[1024];
        int length = bytes.length;
        DatagramPacket dp = new DatagramPacket(bytes, length);
        // 用包数据包接收数据---阻塞式方法，收不到就不走了
        ds.receive(dp);
        // 解析数据包
        // 获取缓冲区数据
        byte[] data = dp.getData();
        // 获取数据实际长度
        int len = dp.getLength();
        String s = new String(data, 0, len);

        InetAddress address = dp.getAddress();
        String hostName = address.getHostAddress();
        System.out.println(hostName + "---" +s);
        // 释放资源
        ds.close();
    }
}
