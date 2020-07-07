package com.daofree;

import java.io.*;
import java.net.Socket;

/**
 * @ClassName ClientKeyDemo
 * @Description: 客户端键盘录入，服务器输出到控制台
 *                  键盘输入流，套接字流
 * @Author DaoTianXia
 * @Date 2020-07-07-9:31
 * @Version V1.0
 **/
public class ClientKeyDemo {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("192.168.0.104", 33333);
        // 键盘录入--读到字符串，字符流
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 把Socket里的流封装一下（字节-字符转换流-高效缓冲流），写到服务端
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

        String line = null;
        while((line = br.readLine()) != null){
            // 键盘录入数据要自定义结束标记
            if("886".equals(line)) {
                break;
            }
            bw.write(line);
            bw.newLine();
            bw.flush();
        }

        //bw.close();封装的就是socket
        //br.close();
        socket.close();
    }
}
