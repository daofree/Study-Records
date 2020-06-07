package com.daofree;

/**
 * @ClassName MyThread
 * @Description: 多线程
 * @Author DaoTianXia
 * @Date 2020-06-07-7:52
 * @Version V1.0
 **/
public class MyThread extends Thread{
    @Override
    public void run() {
        for(int i = 0; i < 100; i++){
            System.out.println(getName() + "----" + i);
        }
    }
}
