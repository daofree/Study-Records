package com.daofree;

/**
 * @ClassName SortThread
 * @Description: 数字排序，线程操作
 * @Author DaoTianXia
 * @Date 2020-06-23-22:58
 * @Version V1.0
 **/
public class SortThread implements Runnable{
    private int num;

    SortThread(int num){
        this.num = num;
    }

    public static void main(String[] args) {
        int[] ints = {102, 338, 62, 132,133,131, 580, 666};
        for(int a :ints){
            new Thread(new SortThread(a)).start();
        }
    }
    @Override
    public void run() {
        try {
            Thread.sleep(this.num);
            System.out.println(this.num);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
