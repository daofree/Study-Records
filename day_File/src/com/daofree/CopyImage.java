package com.daofree;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @ClassName CopyImage
 * @Description: 复制图片案例，一次一个字节
 *                  复制视频很大时，就会很慢，一次一个字节
 * @Author DaoTianXia
 * @Date 2020-05-24-17:11
 * @Version V1.0
 **/
public class CopyImage {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("太极.jpg");
        FileOutputStream fos = new FileOutputStream("taiji.jpg");

        int read = 0;
        while((read = fis.read()) != -1){
            fos.write(read);
        }

        fis.close();
        fos.close();
    }
}
