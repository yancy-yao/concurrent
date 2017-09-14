package com.yancy.concurrent.lock.readwrite;

public class Writer implements Runnable{

	private PricesInfo pricesInfo;
	
	public Writer(PricesInfo pricesInfo){
		this.pricesInfo = pricesInfo;
	}
	
	@Override
	public void run() {
		for(int i=0;i<3;i++){
			System.out.println("Writer: Attempt");
			pricesInfo.setPrices(Math.random()*10, Math.random()*18);
			System.out.println("Writer: complete");
			try{
				Thread.sleep(2);
			}catch(InterruptedException e){
				e.printStackTrace();
			}
			
		}
	}
}
