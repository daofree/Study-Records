package com.daofree;

import java.io.IOException;

/**
 * @ClassName DesignDemo
 * @Description: 简单工厂模式
 * @Author DaoTianXia
 * @Date 2020-06-11-22:40
 * @Version V1.0
 **/
public class DesignDemo {
    public static void main(String[] args) throws IOException {
        Runtime runtime = Runtime.getRuntime();
        // runtime.exec("notepad");
        runtime.exec("calc");
        // runtime.exec("shutdown -s -t 100000");倒计时关机
        // runtime.exec("shutdown -a");取消关机任务
    }
}
