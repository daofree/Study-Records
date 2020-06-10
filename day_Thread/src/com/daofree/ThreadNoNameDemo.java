package com.daofree;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * @ClassName ThreadNoNameDemo
 * @Description: 匿名内部类（子类对象）实现多线程
 *
 *      public class FutureTask<V> implements RunnableFuture<V>
 *      public interface RunnableFuture<V> extends Runnable, Future<V> {
 *          void run();
 *      }
 *
 *          FutureTask是Future接口的一个唯一实现类。也是Runnable的实现类
 *          提供了2个构造器：
 *      public FutureTask(Callable<V> callable) {
 *      }
 *      public FutureTask(Runnable runnable, V result) {
 *      }
 *
 * @Author DaoTianXia
 * @Date 2020-06-09-23:52
 * @Version V1.0
 **/
public class ThreadNoNameDemo {
    public static void main(String[] args) {
        // 一个匿名内部类嵌套
        new Thread(){
            @Override
            public void run() {
                System.out.println("匿名内部类--" + Thread.currentThread().getName());
            }
        }.start();

        // 两个匿名内部类嵌套
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Runnable。。。。" + Thread.currentThread().getName());
            }
        }){
            @Override
            public void run() {
                System.out.println("Thread-----------" + Thread.currentThread().getName());
            }
        }.start();

        //
        new Thread(new FutureTask<Integer>(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                System.out.println("FutureTask是Future接口的一个唯一实现类,顶层extends Runnable, Future<V>"
                        + Thread.currentThread().getName());
                return 1;
            }
        })).start();

    }
}
