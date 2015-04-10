package SynchronizeTest;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * ���� Executor.execute .submit���� 
 * (1)execute ���� ʵ��runnable�ӿ� 
 *    submit  ����ʵ��callable �ӿ�  
 * (2)execute �޷������߳�ִ�н�� submit ���Խ���Future<String> ִ�н��
 * (3)execute�޷������쳣 submit ��call()�������׳��쳣����Future.get�в����쳣�����д���
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