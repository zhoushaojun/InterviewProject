package SynchronizeTest;

import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadLocalTest {
	public static void runTest(){
		ExecutorService executorService = Executors.newCachedThreadPool();
		MyRunnable runnable = new MyRunnable();
		executorService.execute(new Thread(runnable));
		executorService.execute(new Thread(runnable));
		executorService.execute(new Thread(runnable));
	}
	public static void main(String[] args) {
		runTest();
	}
}

class MyRunnable implements Runnable{
	public static final MyThreadLocal threadLocal = new MyThreadLocal();
	
	public void run() {
		HashMap<String, String> map = threadLocal.get();
		System.out.println(map);
	}
}

class MyThreadLocal extends ThreadLocal<HashMap<String, String>>{
	
	protected HashMap<String, String> initialValue() {
		System.out.println(Thread.currentThread().getName()+" : initValue");
		return new HashMap<String, String>();
	}
	
	public HashMap<String, String> get() {
		HashMap<String, String> map = super.get();
		System.out.println("First get");
		for (int i = 0; i < 5; i++) {
			map.put(Thread.currentThread().getName()+" "+String.valueOf(i), String.valueOf(i));
		}
		super.set(map);
		return super.get();
	}
	
	
	
}