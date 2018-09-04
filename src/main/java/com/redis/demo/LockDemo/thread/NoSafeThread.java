package com.redis.demo.LockDemo.thread;

public class NoSafeThread extends Thread {

	// 为了保持票数的一致，票数要静态
	static int tick = 20;
	// 创建一个静态钥匙
	static Object ob = "aa";// 值是任意的

	@Override
	public void run() {
		while (tick > 0) {
			synchronized (NoSafeThread.class) {// 这个很重要，必须使用一个锁，
				// 进去的人会把钥匙拿在手上，出来后才把钥匙拿让出来
				if (tick > 0) {
					System.out.println(Thread.currentThread().getName() + "卖出了第" + tick + "张票");
					tick--;
				} else {
					System.out.println("票卖完了");
				}
			}
			try {
				sleep(1000);// 休息一秒
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		NoSafeThread nst = new NoSafeThread();
		Thread t1 = new Thread(nst, "t1");
		Thread t2 = new Thread(nst, "t2");
		Thread t3 = new Thread(nst, "t3");

		t1.start();
		t2.start();
		t3.start();

	}

}
