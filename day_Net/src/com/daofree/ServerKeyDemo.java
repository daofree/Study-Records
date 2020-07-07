package com.daofree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @ClassName ServerKeyDemo
 * @Description: 客户端键盘录入，服务器输出到控制台--通道流
 * @Author DaoTianXia
 * @Date 2020-07-07-9:51
 * @Version V1.0
 **/
public class ServerKeyDemo {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(33333);
        Socket s = ss.accept();

        // 包装通道内的流
        BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
        String line = null;
        while((line = br.readLine() ) != null){
            System.out.println(line);
        }

        // br.close();
        s.close();
        // ss.close();
    }
}
