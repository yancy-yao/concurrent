package com.yancy.concurrent.executor;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class Server {

	private ThreadPoolExecutor executor;
	
	public Server() {
		executor = (ThreadPoolExecutor)Executors.newCachedThreadPool();
	}
	
	public void executeTask(Task task){
		System.out.println("Server: a new task ");
		executor.execute(task);
		System.out.println("Server: pool size "+executor.getPoolSize());
		System.out.println("Server: active count "+executor.getActiveCount());
		System.out.println("Server: complete count "+executor.getCompletedTaskCount());
	}
	
	public void endServer(){
		executor.shutdown();
	}
	
	public static void main(String[] args) {
		Server server = new Server();
		for(int i=0; i<100; i ++){
			Task task = new Task("Task"+i);
			server.executeTask(task);
		}
		server.endServer();
	}
}
