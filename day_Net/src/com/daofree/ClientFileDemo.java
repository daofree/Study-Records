package com.daofree;

import java.io.*;
import java.net.Socket;

/**
 * @ClassName ClientFileDemo
 * @Description: 客户端键盘录入，服务器输出到文本文件
 * @Author DaoTianXia
 * @Date 2020-07-07-10:08
 * @Version V1.0
 **/
public class ClientFileDemo {
    public static void main(String[] args) throws IOException {
        Socket s = new Socket("192.168.0.104", 44444);
        // 封装键盘输入流
        InputStream in = System.in;
        BufferedReader br = new BufferedReader(new InputStreamReader(in));

        // 封装通道输出流
        OutputStream os = s.getOutputStream();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os));
        String line = null;
        while((line = br.readLine()) != null){
            if("end".equals(line)){
                break;
            }
            bw.write(line);
            bw.newLine();
            bw.flush();
        }

        s.close();
    }
}
