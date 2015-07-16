package com.netease.java.cocurrent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/**
 * 乐观 悲观锁实现
 * 悲观锁 利用 锁等待机制 一直等待
 * 乐观所 一直循环等待version 判断相同则进行处理
 * @author zhoushaojun
 *
 */

public class PessismOptisimisticLock {

	private static int count = 1;
	private static HashMap<String, Integer> versionMap = new HashMap<String, Integer>();
	private static List<String> data = new ArrayList<String>();
	static {
		versionMap.put("version", 1);
	}

	public void storeNum() throws InterruptedException {
		int version = versionMap.get("version");
		do {
			// 第一次判断 version 是否相等
			if (version == (int) versionMap.get("version")) {
				Thread.sleep(200);
				synchronized (this) {
					// 第二次判断 version 是否相等
					if (version != (int) versionMap.get("version")) {
						continue;
					}
					System.out.println(Thread.currentThread().getName() + " get version " + version);
					data.add(Thread.currentThread().getName() + " value : " + count++);
					int num = versionMap.get("version");
					versionMap.put("version", ++num);

				}
				break;
			} else {
				version = versionMap.get("version");
			}
		} while (true);

	}

	public static void execute() {
		ExecutorService service = new ThreadPoolExecutor(20, 40, 60L, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(100),
				new ThreadPoolExecutor.CallerRunsPolicy());

		PessismOptisimisticLock enLock = new PessismOptisimisticLock();
		for (int i = 0; i < 200; i++) {
			service.execute(new MyRunable(enLock));
		}
		try {
			Thread.sleep(60000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		for (String element : data) {
			System.out.println(element);

		}
	}

	public static void main(String[] args) {
		execute();
	}
}

class MyRunable implements Runnable {
	private PessismOptisimisticLock entity;

	public MyRunable(PessismOptisimisticLock outter) {
		this.entity = outter;
	}

	public void run() {
		try {
			entity.storeNum();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
}