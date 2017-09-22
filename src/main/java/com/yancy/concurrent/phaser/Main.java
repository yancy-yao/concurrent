package com.yancy.concurrent.phaser;

import java.util.concurrent.Phaser;

/**
 * Created by yaoxin on 2017/9/18.
 */
public class Main {

    public static void main(String[] args) {
        Phaser phaser = new Phaser(3);
        FileSearch system = new FileSearch("D:\\btc\\logs", "log", phaser);
        FileSearch apps = new FileSearch("D:", "log", phaser);
        FileSearch documents = new FileSearch("D:", "log", phaser);

        Thread systemThread = new Thread(system, "System");
        systemThread.start();

        Thread appsThread = new Thread(apps, "Apps");
        appsThread.start();

        Thread documentsThread = new Thread(documents, "Documents");
        documentsThread.start();

        try{
            systemThread.join();;
            appsThread.join();
            documentsThread.join();
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("Terminated: "+phaser.isTerminated());
    }

}
