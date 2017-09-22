package com.yancy.concurrent.executor.schedule;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by yaoxin on 2017/9/19.
 */
public class Main {

    public static void main(String[] args) {
        ScheduledThreadPoolExecutor executor = (ScheduledThreadPoolExecutor)Executors.newScheduledThreadPool(1);
        for (int i = 0; i < 5; i++) {
            Task task = new Task("Task "+i);
            executor.schedule(task, i+1, TimeUnit.SECONDS);
        }
        executor.shutdown();
        try{
            executor.awaitTermination(1, TimeUnit.DAYS);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("Main: Ends at:" +new Date());
    }
}
