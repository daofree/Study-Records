package com.daofree;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @ClassName FileOutputStreamDemo1
 * @Description: 字节输出流demo
 * @Author DaoTianXia
 * @Date 2020-05-24-10:18
 * @Version V1.0
 **/
public class FileOutputStreamDemo1 {
    public static void main(String[] args) throws IOException {
        FileOutputStream fos = new FileOutputStream("fos.txt");
        //fos.write("hello,IO".getBytes());
        fos.write(97);
        // 字符97
        // 字节97，底层二进制数据，用记事本打开会找97对应的字符值，
        fos.write("\n".getBytes());
        fos.write(57);
        fos.write(55);

        fos.close();
        System.out.println("写完了");
    }
}
