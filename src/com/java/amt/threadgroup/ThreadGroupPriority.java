package com.java.amt.threadgroup;

/**
 * @author ${Suresh M Kumar}
 *
 * Jan 9, 2018
 */
public class ThreadGroupPriority {

	public static void main(String[] args) {
		
		/***Creating a new thread group called first with default parent thread group i.e., main (as this code belongs to main method)*/
		ThreadGroup firstGroup=new ThreadGroup("first");
		
		/***Creating two new threads and attaching those threads to first thread group*/
		Thread thread1=new Thread(firstGroup, "thread 1");
		Thread thread2=new Thread(firstGroup, "thread 2");
		
		/***Printing the priorities of group and threads.****/
		System.out.println(firstGroup.getName()+" group :: " +firstGroup.getMaxPriority());
		System.out.println(thread1.getName()+" :: " +thread1.getPriority());
		System.out.println(thread2.getName()+" :: " +thread2.getPriority());
		
		/***Changing the group priority from default (default is 10) to 1.****/
		firstGroup.setMaxPriority(1);
		
		/***Creating a new thread and attaching to first thread group*/
		Thread thread3=new Thread(firstGroup, "thread 3");
		
		/***Printing the priorities of group and threads.****/
		System.out.println(firstGroup.getName()+" group :: " +firstGroup.getMaxPriority());
		System.out.println(thread1.getName()+" :: " +thread1.getPriority());
		System.out.println(thread2.getName()+" :: " +thread2.getPriority());
		System.out.println(thread3.getName()+" :: " +thread3.getPriority());
		
		/**
		*****************************
		*	::OUTPUT ::				*
		*							*
		*	first group :: 10		*
		*	thread 1 :: 5			*
		*	thread 2 :: 5			*
		*	first group :: 1		*
		*	thread 1 :: 5			*
		*	thread 2 :: 5			*
		*	thread 3 :: 1			*
		*							*
		*							*
		*****************************
		**/
		
		
		/***The change in the thread group priority would not
		 	effects the threads which are all already present
		 	in the thread group. The new priority only applicable
		 	for the threads which are created after the priority changes.
		 	
		 	In the above example, we can see the thread1 and thread2
		 	contains the default thread group priority i.e., 5 but, 
		 	thread3 having the new priority which is 1.*/
	}

}
