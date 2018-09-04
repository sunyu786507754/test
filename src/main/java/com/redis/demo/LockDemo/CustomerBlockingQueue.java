package com.redis.demo.LockDemo;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * 消费者消息列
 * @author Administrator
 *
 */
public class CustomerBlockingQueue extends Thread{
	
	private ArrayBlockingQueue<String> abq;
	
	public CustomerBlockingQueue(ArrayBlockingQueue<String> abq){
		this.abq=abq;
	}
	@Override
	public void run() {
//		super.run();
		while(true){
			try {
				Thread.sleep(1000);
				String str=abq.take();
				System.out.println(Thread.currentThread().getName()+"取出数据:"+str);
				int a=abq.remainingCapacity();
				System.out.println(Thread.currentThread().getName()+"提示剩余元素个数:"+a);
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
		}
	}
}
