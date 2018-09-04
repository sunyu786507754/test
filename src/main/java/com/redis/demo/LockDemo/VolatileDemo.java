package com.redis.demo.LockDemo;
/**
 * volatile测试
 * @author Administrator
 *
 */
public class VolatileDemo {
	private volatile int x=0;
	
	private void write(){
		x=1;
	}
	
	private void read(){
		while(x!=1){
			System.out.println("进入循环");
		}
		System.out.println("read执行完毕");
	}
	
	public static void main(String[] args) {
		final VolatileDemo vd=new VolatileDemo();
		
		Thread t1=new Thread(new Runnable() {
			public void run() {
				vd.write();
			}
		});
		
		Thread t2=new Thread(new Runnable() {
			public void run() {
				vd.read();
			}
		});
		
		
		t1.start();
		t2.start();
		
	}
	
}
