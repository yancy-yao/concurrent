package com.yancy.concurrent.executor;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Task implements Runnable{

	private Date initDate;
	
	private String name;
	
	public Task(String name) {
		initDate = new Date();
		this.name = name;
	}
	
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName()+": Task "+name+
				" created on "+initDate);
		System.out.println(Thread.currentThread().getName()+": Task "+name+
				" start on "+new Date());
		try{
			Long duration = (long)(Math.random()*10);
			System.out.println(Thread.currentThread().getName()+": Task "+name+
					" doing duration "+duration);
			TimeUnit.SECONDS.sleep(duration);
		}catch(InterruptedException e){
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName()+": Task "+name+
				" finish on "+new Date());
	}

}
