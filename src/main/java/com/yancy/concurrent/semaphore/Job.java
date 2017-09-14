package com.yancy.concurrent.semaphore;

public class Job implements Runnable{

	private PrintQueue printQueue;
	
	public Job(PrintQueue printQueue){
		this.printQueue = printQueue;
	}
	
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName()+":going to print");
		printQueue.printJob(new Object());
		System.out.println(Thread.currentThread().getName()+":has been print");
	}

}
