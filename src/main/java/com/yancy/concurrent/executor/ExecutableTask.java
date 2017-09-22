package com.yancy.concurrent.executor;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
 * Created by yaoxin on 2017/9/19.
 */
public class ExecutableTask implements Callable<String>{

    private String name;

    public String getName() {
        return name;
    }

    public ExecutableTask(String name) {
        this.name = name;
    }

    @Override
    public String call() throws Exception {
        try{
           long duration = (long)(Math.random()*10);
           System.out.println(this.name + ":Waiting "+duration);
            TimeUnit.SECONDS.sleep(duration);
        }catch (InterruptedException e){

        }
        return "Hello, world. "+name;
    }
}
