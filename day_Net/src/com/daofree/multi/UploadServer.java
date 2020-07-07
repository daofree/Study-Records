package com.daofree.multi;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @ClassName UploadServer
 * @Description: 多个客户端上传一个服务器
 * @Author DaoTianXia
 * @Date 2020-07-07-17:29
 * @Version V1.0
 **/
public class UploadServer {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(43210);
        while(true){
            Socket as = ss.accept();
            UserThread ut = new UserThread(as);
            new Thread(ut).start();
        }
    }
}
