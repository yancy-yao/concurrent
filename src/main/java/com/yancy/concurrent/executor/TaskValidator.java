package com.yancy.concurrent.executor;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;

/**
 * Created by yaoxin on 2017/9/19.
 */
public class TaskValidator implements Callable<String> {

    private UserValidator validator;

    private String user;

    private String password;

    public TaskValidator(UserValidator validator, String user, String password){
        this.validator = validator;
        this.user = user;
        this.password = password;
    }

    @Override
    public String call() throws Exception{
        if(!validator.validate(user, password)){
            System.out.println(validator.getName() + ": The user has not bean found.");
            throw new Exception("Error validation");
        }
        System.out.println(validator.getName() + ": The user has bean found.");
        return validator.getName();
    }
}
