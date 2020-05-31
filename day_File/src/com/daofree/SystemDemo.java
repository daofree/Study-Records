package com.daofree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * @ClassName SystemDemo
 * @Description: 早期键盘录入数据
 * @Author DaoTianXia
 * @Date 2020-05-31-14:30
 * @Version V1.0
 **/
public class SystemDemo {
    public static void main(String[] args) throws IOException {
        // 一次读取一个字节
        InputStream in = System.in;
        int read = in.read();
        System.out.println(read);
        System.out.println("-------------");

        // 一次读取一行，有BufferedReader的readLine方法
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        System.out.println(s);

    }
}
