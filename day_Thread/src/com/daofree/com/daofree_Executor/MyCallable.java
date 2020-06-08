package com.daofree.com.daofree_Executor;

import java.util.concurrent.Callable;

/**
 * @ClassName MyCallable
 * @Description: 线程第三种方案--带泛型的接口---带返回值的线程--依赖线程池实现
 *              Callable<V>的泛型是 V call()返回值的类型
 * @Author DaoTianXia
 * @Date 2020-06-09-0:17
 * @Version V1.0
 **/
public class MyCallable implements Callable<Integer> {
    private int start = 0;
    private int stop = 0;

    public MyCallable() {
    }

    public MyCallable(int start, int stop) {
        this.start = start;
        this.stop = stop;
    }

    @Override
    public Integer call() throws Exception {
        int sum = 0;
        for (int i = start; i <= stop; i++) {
            sum += i;
        }
        System.out.println(Thread.currentThread().getName() + "---" + sum);
        return sum;
    }
}
