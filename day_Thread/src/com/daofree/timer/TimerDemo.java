package com.daofree.timer;

import java.util.Timer;
import java.util.TimerTask;

/**
 * @ClassName TimerDemo
 * @Description: 定时器与任务类
 *         public Timer()
 *         public void schedule(TimerTask task, long delay)
 *         public void schedule(TimerTask task, long delay, ling period)
 *         public void cancel()
 *
 * @Author DaoTianXia
 * @Date 2020-06-10-21:27
 * @Version V1.0
 **/
public class TimerDemo {
    public static void main(String[] args) {
        Timer timer = new Timer();
        // timer.schedule(new MyTask(), 3000);
        // timer.schedule(new MyTask(timer), 3000);
        timer.schedule(new MyTask(), 3000, 2000);

    }
}

class MyTask extends TimerTask{
    private Timer t;
    public MyTask(){

    }
    public MyTask(Timer timer){
        this.t = timer;
    }

    @Override
    public void run() {
        System.out.println("Boom。。。");
        //t.cancel();
    }
}
