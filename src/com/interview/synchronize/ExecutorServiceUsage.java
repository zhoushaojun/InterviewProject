package com.interview.synchronize;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.springframework.scheduling.concurrent.CustomizableThreadFactory;

/**
 * 测试 Executor.execute .submit区别 
 * (1)execute 接受 实现runnable接口 
 *    submit  接受实现callable 接口  
 * (2)execute 无法返回线程执行结果 submit 可以接受Future<String> 执行结果
 * (3)execute无法处理异常 submit 在call()方法中抛出异常。在Future.get中捕获异常，进行处理
 * 
 * @author zhoushaojun
 * invokeAny()
 * 返回最先正常完成(without throwing exception)的任务直接结果；
 * 一旦有任务正常完成或者调用出现异常，线程池都会终止正在运行或等待运行(tasks that have not completed are cancelled)的任务
 * 
 * nvokeAll()
 * 是一个阻塞方法，会等待任务列表中的所有任务都执行完成。不管任务是正常完成，还是异常终止，Future.isDone()始终返回true
 * 
 */
public class ExecutorServiceUsage {
	private static ArrayList<Future<String>> result = new ArrayList<Future<String>>();

	/**
	 * 创建线程池
	 */
    public static ExecutorService createThreadPool(String threadPoolName) {
        CustomizableThreadFactory threadFactory = new CustomizableThreadFactory(threadPoolName);
        // 尽可能多地缓冲，减少对数据库的访问
        return new ThreadPoolExecutor(10, 20, 60, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>(8000), threadFactory,
                new ThreadPoolExecutor.CallerRunsPolicy());
    }
	public static void executeCore() {
		ExecutorService service = Executors.newFixedThreadPool(3);
		
		/** Submit提交 Callable Test
		 * 
		 * 
		for (int i = 0; i < 10; i++) {
			Future<String> fu = service.submit(new callableTask(String.valueOf(i)));
			result.add(fu);
		}

		// service.shutdown();
		for (Future<String> element : result) {
			try {
				System.out.println(element.get());
			} catch (Exception e) {
				List<Runnable> rs = service.shutdownNow();
				e.printStackTrace();
				System.out.println("stopnow size is " + rs.size());
				return;
			}
		}
		**/
		
		/**
		 * InvokeAll 测试
		 */
		List<CallableTask> callableTasks = new ArrayList<CallableTask>();
		for (int i = 0; i < 10; i++) {
			callableTasks.add(new CallableTask(String.valueOf(i)));
		}
		List<Future<String>> result = null;
		try {
			result = service.invokeAll(callableTasks);
		} catch (InterruptedException e) {
			System.out.println("invoke exception");
			e.printStackTrace();
		}
		for (Future<String> future : result) {
			try {
				System.out.println(future.get());
			} catch (Exception e) {
				System.out.println("get exception");
				e.printStackTrace();
			}
		}

		/**
		 * InvokeAny
		 */
		/**
		 * for (int i = 0; i < 10; i++) {
		 *  callableTasks.add(new CallableTask(String.valueOf(i))); 
		 * } 
		 * 
		 * List<Future<String>> result = null;
		 *  try { 
		 *  	 String resuString = service.invokeAny(callableTasks);
		 *		 System.out.println(resuString); 
		 * } catch (Exception e) {
		 * 
		 * 		System.out.println("invoke exception"); e.printStackTrace();
		 * 
		 *  }
		 */
	}

	public static void main(String[] args) {
		executeCore();
	}
}

class CallableTask implements Callable<String> {
	private String id;

	public CallableTask(String id) {
		this.id = id;
	}

	public String call() throws Exception {
		System.out.println("id " + id + " call()方法被自动调用,干活！！！             " + Thread.currentThread().getName());

		// 一个模拟耗时的操作
		try {
			//Thread.sleep(Integer.valueOf(id) * 4000);
			if (id.equals("3")) {
				throw new Exception();
			}
		} catch (Exception e) {
			throw e;
		}
		return "id " + id + " lengjing + call()方法被自动调用，任务的结果是：" + id + "    " + Thread.currentThread().getName();
	}

}