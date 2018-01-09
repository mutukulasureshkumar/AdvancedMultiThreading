package com.java.amt.threadgroup;


/****
 * 
 * @author ${Suresh M Kumar}
 *
 * Jan 9, 2018
 * 
 * In Java, every class must belongs to any of the thread group.
 * system thread group is one of the super thread group of Java. By default all the main classes are falls under main thread group.
 * The parent thread group of main thread group is system thread group.
 * 
 *  This class will demonstrate creating of thread groups and relating to parent thread group.
 */

/**
 * @author ${Suresh M Kumar}
 *
 * Jan 9, 2018
 */
public class ThreadGroupImpl {

	public static void main(String[] args) {
		
		/***Getting the top most thread group i.e., system*/
		ThreadGroup parentThreadGroup=Thread.currentThread().getThreadGroup().getParent();
		
		/***Creating a new thread group called first with default parent thread group i.e., main (as this code belongs to main method)*/
		ThreadGroup firstGroup=new ThreadGroup("first");
		
		/***Creating a new thread group called second and attaching this thread group to system thread group 
		 * i.e, parent thread group of this second thread group is system*/
		ThreadGroup secondGroup=new ThreadGroup(parentThreadGroup, "second");
		
		/***Creating a new thread group called third and attaching to first thread group */
		ThreadGroup thirdGroup=new ThreadGroup(firstGroup, "third");
		
		/***Creating a new thread group called fourth and attaching to second thread group */
		ThreadGroup fourthGroup=new ThreadGroup(secondGroup, "fourth");
		
		/***Now printing the group hierarchy of third and fourth group*/
		getgroupHierarchy(thirdGroup);
		getgroupHierarchy(fourthGroup);
	}
	
	/**This recurrent will get the parent thread group***/
	public static void getgroupHierarchy(ThreadGroup threadGroup){
		if(threadGroup.getParent() != null){
			System.out.print(threadGroup.getName()+ " --> ");
			getgroupHierarchy(threadGroup.getParent());
		}else{
			System.out.println(threadGroup.getName());
		}
	}

}
