package com.daofree;

import java.io.File;
import java.io.IOException;

/**
 * @ClassName FileDemo1
 * @Description: 抽象File
 * @Author DaoTianXia
 * @Date 2020-05-23-16:36
 * @Version V1.0
 **/
public class FileDemo1 {
    public static void main(String[] args) throws IOException {
        File file = new File("G:\\fileTest\\aaa");
        System.out.println(file.mkdirs());
        File file2 = new File("G:\\fileTest\\aaa\\a.txt");
        System.out.println(file2.createNewFile());
        System.out.println(file2.toString());
        System.out.println("----" + file2);

        System.out.println(file.delete());
        System.out.println(file2.delete());

    }
}
