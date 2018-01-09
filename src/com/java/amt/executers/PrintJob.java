package com.java.amt.executers;

public class PrintJob implements Runnable {
	
	private String name;
	
	public PrintJob(String name) {
		this.name=name;
	}

	@Override
	public void run() {
		System.out.println(name +" job print by "+Thread.currentThread().getName());
		try{
			Thread.sleep(2000);
		}catch (Exception e) {
		}
	}

}
