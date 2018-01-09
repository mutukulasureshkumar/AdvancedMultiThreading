package com.java.amt.locks;

import java.util.concurrent.locks.ReentrantLock;

public class SyncWithReentrantLock {

	public static void main(String[] args) {
		Display display=new Display();
		MyThread myThread1=new MyThread(display,"Suresh");
		MyThread myThread2=new MyThread(display,"Kumar");
		myThread1.start();
		myThread2.start();
		
	}

}

class MyThread extends Thread{
	String name;
	Display display;
	public MyThread(Display display, String name){
		this.display=display;
		this.name=name;
	}
	
	@Override
	public void run() {
		display.print(name);
	}
}

class Display{
	ReentrantLock reentrantLock=new ReentrantLock();
	public void print(String name){
		reentrantLock.lock(); //---------------------> This acts as a synchronized keyword.
		for(int i=0; i<10; i++){
			System.out.println(name);
			try{
				Thread.sleep(1000);
			}catch (InterruptedException e) {
				e.printStackTrace();
			}
			reentrantLock.unlock();

			System.out.println(" Mutukula");
		}
	}
}
