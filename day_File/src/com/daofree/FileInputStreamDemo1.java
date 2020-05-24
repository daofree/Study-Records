package com.daofree;

import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @ClassName FileInputStreamDemo1
 * @Description: 文件读取-----一次一个字节
 * @Author DaoTianXia
 * @Date 2020-05-24-16:17
 * @Version V1.0
 **/
public class FileInputStreamDemo1 {
    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream("fos.txt");
        FileOutputStream fot = new FileOutputStream("a.txt");
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fot);
//        int r = fileInputStream.read();
//        while (r != -1){
//            System.out.print((char)r);
//            r = fileInputStream.read();
//        }

        //最大就是文本字节大小
        byte[] b = new byte[44];
//        int r = fileInputStream.read(b);
//        System.out.println("每次实际读取的字节数" + r);
//        System.out.println(new String(b));

        int len = 0;
        while((len = fileInputStream.read(b)) != -1){
            System.out.println(new String(b,0,len));
        }


//        // 读取，赋值，判断（游标下移）
//        int read = 0;
//        while ((read = fileInputStream.read()) != -1){
//            fot.write(read);
//        }



        fileInputStream.close();
        fot.close();
    }
}
