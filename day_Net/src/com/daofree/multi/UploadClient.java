package com.daofree.multi;

import java.io.*;
import java.net.Socket;

/**
 * @ClassName UploadClient
 * @Description: 多个客户端上传一个服务器
 * @Author DaoTianXia
 * @Date 2020-07-07-17:17
 * @Version V1.0
 **/
public class UploadClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("192.102.0.104",43210);
        // 客户端本地输入流
        BufferedReader br = new BufferedReader(new FileReader("D:\\IdeaProjects\\Study-Records\\JavaSE笔记\\网络编程.md"));
        // 客户端通道输出流
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        // 客户端通道输出
        String line = null;
        while((line = br.readLine()) != null){
            bw.write(line);
            bw.newLine();
            bw.flush();
        }
        // 通知
        socket.shutdownOutput();
        // 客户端通道输入流--反馈
        BufferedReader brClient = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String s = brClient.readLine();
        System.out.println(s);

        br.close();
        socket.close();
    }
}
