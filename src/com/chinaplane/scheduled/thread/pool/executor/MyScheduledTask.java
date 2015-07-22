package com.chinaplane.scheduled.thread.pool.executor;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class MyScheduledTask {

	public static ScheduledThreadPoolExecutor scheduled = new ScheduledThreadPoolExecutor(2);

	private static String getTimes() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss E");
		Date date = new Date();
		return format.format(date);
	}

	public static void handleTimeTask() {
		MyRunnable myRunnable = new MyRunnable();
		// scheduled.scheduleAtFixedRate(myRunnable, 10, 5, TimeUnit.SECONDS);
		scheduled.schedule(myRunnable, 3, TimeUnit.SECONDS);
		System.out.println(getTimes());
	}

	public static void main(String[] args) {
		MyScheduledTask.handleTimeTask();
	}
}

class MyRunnable implements Runnable {
	private int index = 0;

	public void run() {
		try {
			index++;
			System.out.println("curIndex : " + index);

			if (1 == index) {
				MyScheduledTask.scheduled.shutdown();
				System.out.println("Õ£÷π¡À");
			}
			int s = 4 / 0;
		} catch (Exception e) {
			System.out.println("Exception");
		}
		return;
	}

}
