package com.yancy.concurrent;

public class Calculator implements Runnable{

	private int number;
	
	public Calculator(int number){
		this.number = number;
	}
	
	@Override
	public void run() {
		for(int i = 0; i < 10; i++){
			System.out.println(Thread.currentThread().getName() + " : " + number + "*" + i
					+ "="+number*i);
		}
	}

}
