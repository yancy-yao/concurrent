package com.yancy.concurrent.executor;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Main {

	public static void main(String[] args) {
		ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(2);
		List<Future<Integer>> results = new ArrayList<Future<Integer>>();
		Random random = new Random();
		for(int i=0; i<10; i++){
			Integer number = random.nextInt(10);
			FactorialCalculator calculator = new FactorialCalculator(number);
			Future<Integer> result = executor.submit(calculator);
			results.add(result);
		}
		
		do{
			System.out.println("Main: complete task "+executor.getCompletedTaskCount());
			for(int i=0; i<results.size(); i++){
				Future<Integer> result = results.get(i);
				System.out.println("Main: Task"+i+":"+result.isDone());
			}
			try{
				TimeUnit.MILLISECONDS.sleep(50);
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		} while (executor.getCompletedTaskCount() < results.size());
		
		System.out.println("Main: Result");
		for(int i=0; i<results.size();i++){
			Future<Integer> result = results.get(i);
			Integer number = null;
			try{
				number = result.get();
			}catch(InterruptedException e){
				e.printStackTrace();
			}catch (ExecutionException e) {
				e.printStackTrace();
			}
			System.out.println("Main: Task"+i+":result="+number);
		}
		executor.shutdown();
	}
}
