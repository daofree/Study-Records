package com.daofree.com.daofree_Executor;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @ClassName ExecutorDemo
 * @Description: 线程池的使用，用完不死，不用新建，除非shutdown,大大节省
 * @Author DaoTianXia
 * @Date 2020-06-08-23:54
 * @Version V1.0
 **/
public class ExecutorDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 线程工厂创建线程池
        ExecutorService es = Executors.newFixedThreadPool(4);
        // 执行
        es.submit(new MyRun());
        es.submit(new MyCallable());
        Future<Integer> f1 = es.submit(new MyCallable(0, 100));
        Future<Integer> f2 = es.submit(new MyCallable(0, 200));
        Integer integer = f1.get();
        Integer integer1 = f2.get();
        System.out.println(integer + "---带返回值的线程----" + integer1);

        // pool-1-thread-2---0 池名-线程名
        // 结束线程池
        es.shutdown();
    }
}
