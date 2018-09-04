package com.redis.demo.LockDemo.thread;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Executor框架练习
 * @author Administrator
 *
 */
public class ExecutorTest {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		System.out.println("------程序运行------");
		Date date1=new Date();
		
		int takeSize=10;
		List<Future> futureList=new ArrayList<Future>();//保存多线程返回结果
		ExecutorService pool=Executors.newFixedThreadPool(takeSize);//创建线程池
		for(int i=0;i<takeSize;i++){
			Callable c=new MyCallable(i+"");
			Future f=pool.submit(c);
			futureList.add(f);
		}
		pool.shutdown();
		// 获取所有并发任务的运行结果  
	   for (Future f : futureList) {  
	    // 从Future对象上获取任务的返回值，并输出到控制台  
	    System.out.println(">>>" + f.get().toString());  
	   }  
	 
	   Date date2 = new Date();  
	   System.out.println("----程序结束运行----，程序运行时间【" 
	     + (date2.getTime() - date1.getTime()) + "毫秒】");  
	}
}
class MyCallable implements Callable<Object>{

	private String taskNum;
	
	public MyCallable(String taskNum){
		this.taskNum=taskNum;
	}
	//相当于线程run方法
	public Object call() throws Exception {
		System.out.println(">>>"+taskNum+"任务启动");
		Date dateTemp1=new Date();
		Thread.sleep(1000);
		Date dateTemp2=new Date();
		long time = dateTemp2.getTime() - dateTemp1.getTime();  
		System.out.println(">>>"+taskNum+"任务结束");
		
		return taskNum + "任务返回运行结果,当前任务时间【" + time + "毫秒】";
	}
	
}
