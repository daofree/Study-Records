package com.daofree.multi;

import java.io.*;
import java.net.Socket;

/**
 * @ClassName UserThread
 * @Description: TODO
 * @Author DaoTianXia
 * @Date 2020-07-07-17:31
 * @Version V1.0
 **/
public class UserThread implements Runnable{
    private Socket as;
    public UserThread(Socket as) {
        this.as = as;
    }

    @Override
    public void run() {
        try {
            // 通道输入流
            BufferedReader br = new BufferedReader(new InputStreamReader(as.getInputStream()));
            // 服务器本地输出流
            String fileName = System.currentTimeMillis() + ".md";
            BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
            // 输出
            String line = null;
            while((line = br.readLine()) != null){
                bw.write(line);
                bw.newLine();
                bw.flush();
            }

            // 给客户端反馈
            BufferedWriter bwServer = new BufferedWriter(new OutputStreamWriter(as.getOutputStream()));
            bwServer.write("文件上成功");
            bwServer.newLine();
            bwServer.flush();

            // 释放资源
            bw.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
