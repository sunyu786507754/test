package com.redis.demo.LockDemo;

import java.util.concurrent.ArrayBlockingQueue;
/**
 * 生产者消息队列
 * @author Administrator
 *
 */
public class ProducerBlockingQueue extends Thread{
	
	private ArrayBlockingQueue<String> abq;
	
	public ProducerBlockingQueue(ArrayBlockingQueue<String> abq){
		this.abq=abq;
	}
	
	@Override
	public void run() {
//		super.run();
		for(int i=0;i<5;i++){
			try {
				abq.put(i+"");
				System.out.println(Thread.currentThread().getName()+"产生数据");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
