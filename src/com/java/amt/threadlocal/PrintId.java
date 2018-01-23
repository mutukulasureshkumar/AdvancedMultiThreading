package com.java.amt.threadlocal;

import java.util.concurrent.Callable;

public class PrintId implements Callable<Integer> {
	
	private static int id;
	private String name;
	
	public PrintId(String name){
		this.name=name;
	}
	
	private static ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>(){
		public Integer initialValue(){
			return ++id;
		}
	};

	@Override
	public Integer call() throws Exception {
		System.out.println(name +" job is executing by thread "+Thread.currentThread().getName());
		return threadLocal.get();
	}

}
