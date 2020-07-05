package com.daofree;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @ClassName InetAddressDemo
 * @Description: 网络编程
 * @Author DaoTianXia
 * @Date 2020-07-03-22:58
 * @Version V1.0
 **/
public class InetAddressDemo {
    public static void main(String[] args) {
        try {
            InetAddress byName = InetAddress.getByName("LAPTOP-TP34TCPG");
            InetAddress byIpName = InetAddress.getByName("192.168.0.105");
            System.out.println(byName);
            System.out.println(byIpName.getHostName());
        } catch (UnknownHostException e) {
            System.out.println("主机名有误");
        }
    }
}
