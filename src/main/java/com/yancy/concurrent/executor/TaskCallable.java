package com.yancy.concurrent.executor;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
 * Created by yaoxin on 2017/9/19.
 */
public class TaskCallable implements Callable<Result> {

    private String name;

    public TaskCallable(String name) {
        this.name = name;
    }

    @Override
    public Result call() throws Exception {
        System.out.println(this.name + ":Staring ...");
        try{
            long duration = (long)(Math.random()*10);
            System.out.println(this.name + ":waiting "+duration + " seconds");
            TimeUnit.SECONDS.sleep(duration);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        int value = 0;
        for (int i=0; i<5; i++){
            value += (int)(Math.random()*1000);
        }
        Result result = new Result();
        result.setName(this.name);
        result.setValue(value);
        System.out.println(this.name+ ":Ends");
        return result;
    }
}
