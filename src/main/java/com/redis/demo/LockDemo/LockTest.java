package com.redis.demo.LockDemo;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockTest {
	private Lock lock=new ReentrantLock();

	
	private void method(Thread thread){
		lock.lock();
		try {
			System.out.println("线程名:"+thread.getName()+"获得了锁");
		} catch (Exception e) {
		} finally{
			System.out.println("线程名:"+thread.getName()+"释放了锁");
			lock.unlock();
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		final LockTest lt=new LockTest();
		
		Thread t1=new Thread(new Runnable() {
			public void run() {
				lt.method(Thread.currentThread());
			}
		},"t1");
		
		
		Thread t2=new Thread(new Runnable() {
			public void run() {
				lt.method(Thread.currentThread());
			}
		},"t2");
		
		Thread t3=new Thread(new Runnable() {
			public void run() {
				lt.method(Thread.currentThread());
			}
		},"t3");
		
		t1.start();
		t2.start();
		t3.start();
		
		
	}

}
