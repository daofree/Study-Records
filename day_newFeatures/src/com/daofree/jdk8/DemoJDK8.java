package com.daofree.jdk8;

/**
 * @ClassName DemoJDK8
 * @Description: JDK8新特性
 * @Author DaoTianXia
 * @Date 2020-08-23-16:49
 * @Version V1.0
 **/
public class DemoJDK8 {
    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "匿名内部类开启新线程...");
            }
        };
        new Thread(runnable).start();

        // 合并
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "匿名内部类开启新线程...");
            }
        }).start();

        // Lambda表达式

    }
}
