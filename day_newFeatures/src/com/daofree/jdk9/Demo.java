package com.daofree.jdk9;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Set;

/**
 * @ClassName DemoLambda
 * @Description: JDK9新特性
 * @Author DaoTianXia
 * @Date 2020-07-26-11:41
 * @Version V1.0
 **/
public class Demo {
    public static void main(String[] args) throws FileNotFoundException {
        // 集合工厂方法,解决“add” 调用，代码重复问题,但出厂数固定了--创建不可变的集合
        Set<Integer> ints = Set.of(1,2,3);
        //boolean add = ints.add(4);
        // UnsupportedOperationException
        //System.out.println(add);
        // UnsupportedOperationException
        //boolean remove = ints.remove(1);
        //System.out.println(remove);


        // 语法糖
        FileReader fileReader = null;
        try {
            fileReader = new FileReader("fos.txt");
            int read = 0;
            while((read = fileReader.read()) != -1){
                System.out.println(read);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(fileReader != null){
                try {
                    fileReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        // java 1.7
        System.out.println("------1.7-----");
        try(FileReader fileReader2 = new FileReader("fos.txt")) {

            int read = 0;
            while((read = fileReader2.read()) != -1){
                System.out.println(read);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // java 1.9
        System.out.println("------1.9-----");
        FileReader fileReader3 = new FileReader("fos.txt");

        try(fileReader3) {
            int read = 0;
            while((read = fileReader3.read()) != -1){
                System.out.println(read);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
