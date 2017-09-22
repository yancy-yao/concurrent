package com.yancy.concurrent.executor;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * Created by yaoxin on 2017/9/19.
 */
public class ResultTask extends FutureTask<String>{

    private String name;

    public ResultTask(Callable<String> callable) {
        super(callable);
        this.name = ((ExecutableTask)callable).getName();
    }

    @Override
    protected void done() {
        if( isCancelled()){
            System.out.println(name + ": Has bean canceled. ");
        }else{
            System.out.println(name + ":Has finished.");
        }
    }
}
