package com.netease.java.cocurrent;

import java.util.HashMap;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import com.sun.org.apache.xml.internal.security.Init;

public class FutureDataMode {
	private static ExecutorService service = new ThreadPoolExecutor(10, 20, 60L, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(100), new ThreadPoolExecutor.CallerRunsPolicy());
	public static FutureData putTask(String originalStr){
		FutureData futureData = new FutureData();
		service.execute(new MyTask(originalStr, futureData));
		return futureData;
	}
	
	public static void processCore(String originalStr){
		FutureData futureData = putTask(originalStr);
		System.out.println("Get Future Data...");
		System.out.println(futureData.getRealData().getData());
		System.out.println("Get Future Data End...");
		service.shutdownNow();
	}
	
	public static void main(String[] args) {
		processCore("zhoushaojun");
	}
	

}

class MyTask implements Runnable{
	private String handerStr;
	private FutureData futureData;
	
	public MyTask(String str, FutureData data) {
		this.handerStr = str;
		this.futureData = data;
	}
	
	public void run() {
		RealData realData = new RealData(handerStr);
		futureData.setRealData(realData);
	}
}



interface Data<T> {
	public T getData();
}
class RealData implements Data<String>{

	private String handlerStr;
	public RealData(String input) {
		handlerStr = input;
		init();
	}
	public void init(){
		try {
			System.out.println("Real Data is creating data.....");
			Thread.sleep(30000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public String getData() {
		return handlerStr+":X-Real Handler";
	}
}

/**
 * （1）notifyAll 防止自己获取锁 从而wait 造成死锁
 * （2）while(!isReady) 循环条件进行检测，放着虚假唤醒造成资源不匹配
 * @author zhoushaojun
 *
 */
class FutureData{
	private volatile boolean isReady = false;
	private Data realData = null;
	
	public synchronized void setRealData(Data realDataOutter){
		if(isReady){
			return;
		}
		this.realData = realDataOutter;
		isReady = true;
		notifyAll();
	}
	
	public synchronized Data getRealData(){
		while(!isReady){
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		return realData;
		
	}
}