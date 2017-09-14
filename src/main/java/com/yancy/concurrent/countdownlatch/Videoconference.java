package com.yancy.concurrent.countdownlatch;

import java.util.concurrent.CountDownLatch;

public class Videoconference implements Runnable{

	private final CountDownLatch controller;
	
	public Videoconference(int number) {
		controller = new CountDownLatch(number);
	}
	
	public void arrive(String name){
		System.out.println(name+" has arrived.");
		controller.countDown();
		System.out.println("waiting for "+ controller.getCount());
	}
	
	@Override
	public void run() {
		System.out.println("inital count:"+ controller.getCount());
		try{
			controller.await();
			System.out.println("all arrive");
		}catch(InterruptedException e){
			e.printStackTrace();
		}
	}

}
