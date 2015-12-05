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
 * ���� Executor.execute .submit���� 
 * (1)execute ���� ʵ��runnable�ӿ� 
 *    submit  ����ʵ��callable �ӿ�  
 * (2)execute �޷������߳�ִ�н�� submit ���Խ���Future<String> ִ�н��
 * (3)execute�޷������쳣 submit ��call()�������׳��쳣����Future.get�в����쳣�����д���
 * 
 * @author zhoushaojun
 * invokeAny()
 * ���������������(without throwing exception)������ֱ�ӽ����
 * һ��������������ɻ��ߵ��ó����쳣���̳߳ض�����ֹ�������л�ȴ�����(tasks that have not completed are cancelled)������
 * 
 * nvokeAll()
 * ��һ��������������ȴ������б��е���������ִ����ɡ�����������������ɣ������쳣��ֹ��Future.isDone()ʼ�շ���true
 * 
 */
public class ExecutorServiceUsage {
	private static ArrayList<Future<String>> result = new ArrayList<Future<String>>();

	/**
	 * �����̳߳�
	 */
    public static ExecutorService createThreadPool(String threadPoolName) {
        CustomizableThreadFactory threadFactory = new CustomizableThreadFactory(threadPoolName);
        // �����ܶ�ػ��壬���ٶ����ݿ�ķ���
        return new ThreadPoolExecutor(10, 20, 60, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>(8000), threadFactory,
                new ThreadPoolExecutor.CallerRunsPolicy());
    }
	public static void executeCore() {
		ExecutorService service = Executors.newFixedThreadPool(3);
		
		/** Submit�ύ Callable Test
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
		 * InvokeAll ����
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
		System.out.println("id " + id + " call()�������Զ�����,�ɻ����             " + Thread.currentThread().getName());

		// һ��ģ���ʱ�Ĳ���
		try {
			//Thread.sleep(Integer.valueOf(id) * 4000);
			if (id.equals("3")) {
				throw new Exception();
			}
		} catch (Exception e) {
			throw e;
		}
		return "id " + id + " lengjing + call()�������Զ����ã�����Ľ���ǣ�" + id + "    " + Thread.currentThread().getName();
	}

}