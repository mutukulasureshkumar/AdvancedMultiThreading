package com.java.amt.threadgroup;

/**
 * @author ${Suresh M Kumar}
 *
 * Jan 9, 2018
 * 
 * 
 * This Program demonstrate some Thread Group methods.
 */
public class ThreadGroupsMethods {
	public static void main(String[] args) {
		/***Creating a new thread group called first with default parent thread group 
		 	i.e., main (as this code belongs to main method)*/
		ThreadGroup firstGroup=new ThreadGroup("first");
		
		/***Creating two new threads and attaching those threads to first thread group*/
		MyThread thread1=new MyThread(firstGroup, "thread 1");
		MyThread thread2=new MyThread(firstGroup, "thread 2");
		
		/***Starting the above two threads**/
		thread1.start();
		thread2.start();
		
		/***activeCount() thread group method returns the number active threads 
		 	present in the thread group.
		 	Here OUTPUT  :: Active Count 1 :: 2 
		 **/
		System.out.println("Active Count 1 :: "+firstGroup.activeCount());
		
		/***list() thread group method returns active thread information 
	 	present in the thread group.
	 	Here OUTPUT  :: java.lang.ThreadGroup[name=first,maxpri=10]
    					Thread[thread 1,5,first]
    					Thread[thread 2,5,first]
    	**/
		firstGroup.list();
		
		/***Changing the group priority from default (default is 10) to 1.****/
		firstGroup.setMaxPriority(1);
		
		/***Creating a new thread and attaching to first thread group*/
		Thread thread3=new Thread(firstGroup, "thread 3");
		thread3.start();
		
		System.out.println("Active Count 2 :: "+firstGroup.activeCount());
		firstGroup.list();
		
		/***Created a Thread array*/
		Thread[] threadArray=new Thread[firstGroup.activeCount()];
		
		/***enumurate() thread group method copies all the active threads 
		 	present in the thread group to the thread array ***/
		firstGroup.enumerate(threadArray);
		
		for(Thread t:threadArray){
			System.out.println(t.getName());
		}
		
		
		
		/**
		*****************************************************
		*				::The OUTPUT ::						*
		*													*
		*	Active Count 1 :: 2								*
		*	java.lang.ThreadGroup[name=first,maxpri=10]		*
		*	    Thread[thread 1,5,first]					*
		*	    Thread[thread 2,5,first]					*
		*	thread 1										*
		*	thread 2										*
		*	Active Count 2 :: 3								*
		*	java.lang.ThreadGroup[name=first,maxpri=1]		*
		*	    Thread[thread 1,5,first]					*
		*	    Thread[thread 2,5,first]					*
		*	    Thread[thread 3,1,first]					*
		*	thread 1										*
		*	thread 2										*
		*	thread 3										*
		*													*
		*****************************************************
		**/
		
	}
}


class MyThread extends Thread{
	public MyThread(ThreadGroup firstGroup, String string) {
		super(firstGroup, string);
	}

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName());
		try {
			sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
