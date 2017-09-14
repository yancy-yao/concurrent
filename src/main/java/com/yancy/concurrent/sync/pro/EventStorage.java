package com.yancy.concurrent.sync.pro;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class EventStorage {

	private int maxSize;
	
	private List<Date> storage;
	
	public EventStorage(){
		maxSize = 10;
		storage = new LinkedList<Date>();
	}
	
	public synchronized void set(){
		while (storage.size() == maxSize){
			try{
				wait();
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}
		storage.add(new Date());
		System.out.println("Set: " + storage.size());
		notifyAll();
	}
	
	public synchronized void get(){
		while(storage.size() == 0){
			try{
				wait();
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}
		System.out.println("Get: " +storage.size()+" "+((LinkedList<?>)storage).poll());
		notifyAll();
	}
}
