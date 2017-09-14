package com.yancy.concurrent.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PrintQueue {

	private final Lock queueLock = new ReentrantLock();
	
	public void printJob(Object document){
		queueLock.lock();
		try{
			Long duration = (long)(Math.random()*10000);
			System.out.println(Thread.currentThread().getName()+":printqueue:"
					+"print a job during"+(duration/1000)+" s");
			Thread.sleep(duration);
		}catch(InterruptedException e){
			e.printStackTrace();
		}
		finally{
			queueLock.unlock();
		}
		
	}
}
