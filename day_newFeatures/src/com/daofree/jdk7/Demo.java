package com.daofree.jdk7;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @ClassName DemoLambda
 * @Description: JDK7新特性
 * @Author DaoTianXia
 * @Date 2020-07-25-10:39
 * @Version V1.0
 **/
public class Demo {
    public static void main(String[] args) {
        // 二进制字面量
        int i = 0B110101;
        System.out.println(i);
        // 数字字面量中间可以出现下划线
        int x = 100_1000;
        System.out.println(x);
        ArrayList<String> list1 = new ArrayList<String>();
        // 泛型简化
        ArrayList<String> list = new ArrayList<>();

        // 自动释放资源
        method();
    }

    private static void method() {
        //try-with-resource
        FileReader fr = null;
        try {
            fr = new FileReader("a.txt");
            int ch = 0;
            while ((ch = fr.read()) != -1){
                System.out.println(ch);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(fr != null){
                try {
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }

        // JDK7新特性
        try(FileReader fr1  = new FileReader("a.txt")) {
            int ch = 0;
            while ((ch = fr1.read()) != -1){
                System.out.println(ch);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
