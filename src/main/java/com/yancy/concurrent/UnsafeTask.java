package com.yancy.concurrent;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class UnsafeTask implements Runnable{

	private Date startDate;
	
	@Override
	public void run() {
		startDate = new Date();
		System.out.println("starting:"+Thread.currentThread().getName()+":"+startDate);
		try{
			TimeUnit.SECONDS.sleep((int)Math.rint(Math.random()*10));
		}catch(InterruptedException e){
			e.printStackTrace();
		}
		System.out.println("finish:"+Thread.currentThread().getName()+":"+startDate);
	}

}
