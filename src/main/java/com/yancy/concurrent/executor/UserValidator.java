package com.yancy.concurrent.executor;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Created by yaoxin on 2017/9/19.
 */
public class UserValidator {

    private String name;

    public UserValidator(String name){
        this.name = name;
    }

    public boolean validate(String name, String password){
        Random random = new Random();
        try{
            long duration = (long)(Math.random()*10);
            System.out.println("Validator "+ this.name+": Validating during "+ duration);
            TimeUnit.SECONDS.sleep(duration);
        } catch (InterruptedException e){
            return false;
        }
        return random.nextBoolean();
    }

    public String getName() {
        return name;
    }
}
