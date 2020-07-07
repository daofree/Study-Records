package com.daofree.test;

import java.io.*;
import java.net.Socket;

/**
 * @ClassName ClientFileDemo
 * @Description: 客户端读取文本文件，服务端控制台输出
 * @Author DaoTianXia
 * @Date 2020-07-07-10:48
 * @Version V1.0
 **/
public class ClientFileDemo {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("192.168.0.104", 34567);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

        // D:\IdeaProjects\Study-Records\JavaSE笔记\网络编程.md
        BufferedReader br = new BufferedReader(new FileReader("D:\\IdeaProjects\\Study-Records\\JavaSE笔记\\网络编程.md"));
        String line = null;
        while((line = br.readLine()) != null){
            bw.write(line);
            bw.newLine();
            bw.flush();
        }
        br.close();
        socket.close();

    }
}
