package com.yancy.concurrent.cyclicbarrier;

public class Grouper implements Runnable{

	private Results results;
	
	public Grouper(Results results) {
		this.results = results;
	}
	
	@Override
	public void run() {
		int finalResult=0;
		System.out.println("grouper: processing...");
		int data[] = results.getData();
		for(int number:data){
			finalResult += number;
		}
		System.out.println("grouper: total result "+finalResult);
	}

}
