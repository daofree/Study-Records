package com.daofree;

/**
 * @ClassName ThreadTest
 * @Description: 线程测试类
 *          运行结果：
 *                 主要1
 *                 0...6
 *                 0...85
 *                主要2
 *                 86...99
 *                7...99
 *                0...58
 *                主要3
 *                59...99
 *
 * @Author DaoTianXia
 * @Date 2020-06-07-7:53
 * @Version V1.0
 **/
public class ThreadTest {
    public static void main(String[] args) {
        new MyThread().start();
        System.out.println("主要1");
        new MyThread().start();
        System.out.println("主要2");
        new MyThread().start();
        System.out.println("主要3");
        System.out.println("main---" +Thread.currentThread().getName());
    }
}
