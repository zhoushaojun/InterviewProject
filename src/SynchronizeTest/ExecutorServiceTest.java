package SynchronizeTest;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 测试 Executor.execute .submit区别 
 * (1)execute 接受 实现runnable接口 submit
 * 	     接受实现callable接口 
 * (2)execute 无法返回线程执行结果 submit 可以接受Future<String> 执行结果
 * (3)execute无法处理异常 submit 在call()方法中抛出异常。在Future.get中捕获异常，进行处理
 * 
 * @author zhoushaojun
 * 
 */
public class ExecutorServiceTest {
	private static ArrayList<Future<String>> result = new ArrayList<Future<String>>();

	public static void executeCore() {
		ExecutorService service = Executors.newFixedThreadPool(3);
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

	}

	public static void main(String[] args) {
		executeCore();
	}
}

class callableTask implements Callable<String> {
	private String id;

	public callableTask(String id) {
		this.id = id;
	}

	public String call() throws Exception {
		System.out.println("id " + id + " call()方法被自动调用,干活！！！             " + Thread.currentThread().getName());

		// 一个模拟耗时的操作
		try {
			Thread.sleep(Integer.valueOf(id) * 4000);
			if (id.equals("3")) {
				throw new Exception();
			}
		} catch (Exception e) {
			throw e;
		}
		return "id " + id + " lengjing + call()方法被自动调用，任务的结果是：" + id + "    " + Thread.currentThread().getName();
	}

}