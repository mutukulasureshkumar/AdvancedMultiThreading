package com.java.amt.threadlocal;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


public class MyThread {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		PrintId[] jobs = { new PrintId("Suresh"), new PrintId("Naresh"), new PrintId("Mahesh"),
				new PrintId("Ramesh"), new PrintId("Paramesh"), new PrintId("Kamesh") };

		ExecutorService service = Executors.newFixedThreadPool(3);

		Future<Integer> i;
		for (PrintId job : jobs){
			i =service.submit(job);
			System.out.println(i.get());
		}
		service.shutdown();
	}

}
