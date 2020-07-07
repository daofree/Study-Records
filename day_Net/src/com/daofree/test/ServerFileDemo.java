package com.daofree.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @ClassName ServerFileDemo
 * @Description: 客户端读取文本文件，服务端控制台输出
 * @Author DaoTianXia
 * @Date 2020-07-07-11:04
 * @Version V1.0
 **/
public class ServerFileDemo {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(34567);
        Socket as = ss.accept();
        BufferedReader br = new BufferedReader(new InputStreamReader(as.getInputStream()));
        String line = null;
        while ((line = br.readLine()) != null){
            System.out.println(line);
        }

        as.close();
    }
}
