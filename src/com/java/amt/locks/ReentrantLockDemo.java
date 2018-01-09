package com.java.amt.locks;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author ${Suresh M Kumar}
 *
 * Jan 11, 2018
 */
public class ReentrantLockDemo {

	public static void main(String[] args) {
		ReentrantLock reentrantLock=new ReentrantLock();
		
		System.out.println(reentrantLock.getHoldCount());
		System.out.println(reentrantLock.isLocked());
		System.out.println(reentrantLock.isFair());
		System.out.println(reentrantLock.isHeldByCurrentThread());
		
		reentrantLock.lock();
		reentrantLock.lock();
		
		System.out.println("-------------------------------------");
		System.out.println(reentrantLock.getHoldCount());
		System.out.println(reentrantLock.isLocked());
		System.out.println(reentrantLock.isFair());
		System.out.println(reentrantLock.isHeldByCurrentThread());
		
		reentrantLock.unlock();
		
		System.out.println("-------------------------------------");
		System.out.println(reentrantLock.getHoldCount());
		System.out.println(reentrantLock.isLocked());
		System.out.println(reentrantLock.isFair());
		System.out.println(reentrantLock.isHeldByCurrentThread());
		
		reentrantLock.unlock();
		
		System.out.println("-------------------------------------");
		System.out.println(reentrantLock.getHoldCount());
		System.out.println(reentrantLock.isLocked());
		System.out.println(reentrantLock.isFair());
		System.out.println(reentrantLock.isHeldByCurrentThread());
		
		
	}
}
