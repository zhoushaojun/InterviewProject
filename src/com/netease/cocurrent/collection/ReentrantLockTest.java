package com.netease.cocurrent.collection;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockTest {
	private static ReentrantLock lock = new ReentrantLock();

	public static void execute() {
		ExecutorService service = new ThreadPoolExecutor(20, 20, 60L, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(100), new ThreadPoolExecutor.CallerRunsPolicy()); 
		for (int i=0; i<2 ; i++) {
			service.execute(new MyRunableReent(lock));
		}
	}
	public static void main(String[] args) {
		execute();
	}

}

class MyRunableReent implements Runnable {
	private ReentrantLock lock;

	public MyRunableReent(ReentrantLock lockOutter) {
		lock = lockOutter;
	}

	public void run() {
		try {
			System.out.println(Thread.currentThread().getName() + " I am waiting......");
			lock.lock();
			System.out.println(Thread.currentThread().getName() + " I get lock......");
			Thread.sleep(5000);
			System.out.println(Thread.currentThread().getName() + " I am sleeping......");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println(Thread.currentThread().getName() + " I discard lock......");
			lock.unlock();
		}

	}

}
