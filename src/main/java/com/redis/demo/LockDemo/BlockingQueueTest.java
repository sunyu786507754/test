package com.redis.demo.LockDemo;

import java.util.concurrent.ArrayBlockingQueue;

public class BlockingQueueTest {
	public static void main(String[] args) {
		ArrayBlockingQueue<String> abq=new ArrayBlockingQueue<String>(3);
		
		ProducerBlockingQueue pbq=new ProducerBlockingQueue(abq);
		CustomerBlockingQueue cbq=new CustomerBlockingQueue(abq);
		
		Thread t1=new Thread(pbq, "product");
		
		Thread t2=new Thread(cbq, "customer1");
		Thread t3=new Thread(cbq, "customer2");
		
		t1.start();
		t2.start();
		t3.start();
		
		
		
	}
}
