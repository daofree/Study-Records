package com.daofree.jdk8;

/**
 * @ClassName DemoJDK8
 * @Description: JDK8新特性
 *              必须实现的方法，从单独实现类，到匿名内部类，事实上
 *              只有方法体才是变化的是关键所在！
 *              lambda表达式来了
 * @Author DaoTianXia
 * @Date 2020-08-23-16:49
 * @Version V1.0
 **/
public class DemoJDK8 {
    public static void main(String[] args) {
        // 从单独实现类到匿名内部类
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

        // Lambda表达式--->箭头函数--->参数传递
        new Thread(()->{
            System.out.println(Thread.currentThread().getName() + "lambda开启新线程...");
        }).start();

    }
}
