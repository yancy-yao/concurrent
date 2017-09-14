package com.yancy.concurrent;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class SafeTask implements Runnable{

	private static ThreadLocal<Date> startDate = new ThreadLocal<Date>(){
		protected Date initialValue(){
			return new Date();
		}
	};
	
	@Override
	public void run() {
		System.out.println("starting:"+Thread.currentThread().getName()+
				":"+startDate.get());
		try{
			TimeUnit.SECONDS.sleep((int)Math.rint(Math.random()*10));
		}catch(InterruptedException e){
			e.printStackTrace();
		}
		System.out.println("finish:"+Thread.currentThread().getName()+
				":"+startDate.get());
	}
}
