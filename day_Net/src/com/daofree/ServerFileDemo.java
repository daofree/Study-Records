package com.daofree;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @ClassName ServerFileDemo
 * @Description: 客户端键盘录入，服务器输出到文本文件
 * @Author DaoTianXia
 * @Date 2020-07-07-10:32
 * @Version V1.0
 **/
public class ServerFileDemo {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(44444);
        Socket s = ss.accept();

        InputStream is = s.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(is));

        BufferedWriter bw = new BufferedWriter(new FileWriter("tcp.txt"));
        String line = null;
        while((line = br.readLine()) != null){
            bw.write(line);
            bw.newLine();
            bw.flush();
        }

        bw.close();
        s.close();
    }
}
