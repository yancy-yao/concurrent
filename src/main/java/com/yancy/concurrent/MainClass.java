package com.yancy.concurrent;

import java.util.concurrent.TimeUnit;

import com.yancy.concurrent.sync.account.Account;
import com.yancy.concurrent.sync.account.Bank;
import com.yancy.concurrent.sync.account.Company;
import com.yancy.concurrent.sync.pro.Consumer;
import com.yancy.concurrent.sync.pro.EventStorage;
import com.yancy.concurrent.sync.pro.Producer;

public class MainClass {

	public static void main(String[] args){
		//case 1
//		for(int i=1; i<=10;i++){
//			Calculator calculator = new Calculator(i);
//			Thread thread = new Thread(calculator);
//			thread.start();
//		}
		
//		UnsafeTask task = new UnsafeTask();
//		SafeTask task = new SafeTask();
//		for(int i=0;i<10;i++){
//			Thread thread = new Thread(task);
//			thread.start();
//			try{
//				TimeUnit.SECONDS.sleep(2);
//			}catch(InterruptedException e){
//				e.printStackTrace();
//			}
//		}
		
		//case 2
//		Account account = new Account();
//		account.setBalance(1000);
//		
//		Company company = new Company(account);
//		Thread companyThread = new Thread(company);
//		
//		Bank bank = new Bank(account);
//		Thread bankThread = new Thread(bank);
//		
//		System.out.println("account: inital balance = "+account.getBalance());
//		companyThread.start();
//		bankThread.start();
//		
//		try{
//			companyThread.join();
//			bankThread.join();
//			System.out.println("account: final balance = "+account.getBalance());
//		} catch(InterruptedException e){
//			e.printStackTrace();
//		}

		//case 3
		EventStorage storage = new EventStorage();
		Producer producer = new Producer(storage);
		Thread thread1 = new Thread(producer);
		
		Consumer consumber = new Consumer(storage);
		Thread thread2 = new Thread(consumber);
		
		thread2.start();
		thread1.start();
	}
}
