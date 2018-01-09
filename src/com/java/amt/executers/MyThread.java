package com.java.amt.executers;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MyThread {

	public static void main(String[] args) {
		PrintJob[] jobs = {new PrintJob("Suresh"),
							new PrintJob("Naresh"),
							new PrintJob("Mahesh"),
							new PrintJob("Ramesh"),
							new PrintJob("Paramesh"),
							new PrintJob("Kamesh")};
		
		ExecutorService service = Executors.newFixedThreadPool(3);
		
		for(PrintJob job : jobs)
			service.execute(job);
		
		service.shutdown();
	}

}
