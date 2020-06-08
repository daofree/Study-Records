package com.daofree.com.daofree_Executor;

/**
 * @ClassName MyRun
 * @Description: 实现Runnable接口的线程
 * @Author DaoTianXia
 * @Date 2020-06-08-23:58
 * @Version V1.0
 **/
public class MyRun implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + "---" + i);
        }
    }
}
