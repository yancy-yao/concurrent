package com.yancy.concurrent.executor;

import com.sun.org.apache.regexp.internal.REUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

public class Main {

	public static void main(String[] args) {
		/*ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(2);
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
		executor.shutdown();*/

		//case 3
		/*String username = "test";
		String password = "test";
		UserValidator ldapValidator = new UserValidator("LDAP");
		UserValidator dbValidator = new UserValidator("DB");
		TaskValidator ldapTask  = new TaskValidator(ldapValidator, username, password);
		TaskValidator dbTask = new TaskValidator(dbValidator, username, password);
		List<TaskValidator> taskList = new ArrayList<>();
		taskList.add(ldapTask);
		taskList.add(dbTask);
		ExecutorService executor = (ExecutorService)Executors.newCachedThreadPool();
		String result;
		try{
			result = executor.invokeAny(taskList);
			System.out.println("Main: Result: "+ result);
		} catch (InterruptedException e){
			e.printStackTrace();
		} catch (Exception e){
			e.printStackTrace();
		}
		executor.shutdown();
		System.out.println("Main: End of the Execution.");*/

		//case 4
		/*ExecutorService executor = (ExecutorService)Executors.newCachedThreadPool();
		List<TaskCallable> taskList = new ArrayList<>();
		for (int i=0; i<3; i++){
			TaskCallable task = new TaskCallable(String.valueOf(i));
			taskList.add(task);
		}
		List<Future<Result>> resultList = null;
		try{
			resultList = executor.invokeAll(taskList);
		} catch (InterruptedException e){
			e.printStackTrace();
		}
		executor.shutdown();
		System.out.println("Main: Printing the results");
		for (int i=0; i<resultList.size(); i++){
			Future<Result> future = resultList.get(i);
			try{
				Result result = future.get();
				System.out.println(result.getName()+":"+result.getValue());
			}catch (InterruptedException | ExecutionException e){
				e.printStackTrace();
			}
		}*/

		//case 5
		ExecutorService executor = Executors.newCachedThreadPool();
		ResultTask resultTask[] = new ResultTask[5];
		for (int i = 0; i < 5; i++) {
			ExecutableTask executableTask = new ExecutableTask("Task "+i);
			resultTask[i] = new ResultTask(executableTask);
			executor.submit(resultTask[i]);
		}
		try{
			TimeUnit.SECONDS.sleep(5);
		}catch (InterruptedException e){
			e.printStackTrace();
		}
		for (int i = 0; i < resultTask.length; i++) {
			resultTask[i].cancel(true);
		}
		for (int i = 0; i < resultTask.length; i++) {
			try{
				if(!resultTask[i].isCancelled()){
					System.out.println(resultTask[i].get());
				}
			}catch (InterruptedException |ExecutionException e){
				e.printStackTrace();
			}
		}
		executor.shutdown();
	}
}
