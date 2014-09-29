package SynchronizeTest;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/**
 * ConcurrentLinkedQueue 为非堵塞队列
 * 适用于，主线程 进行填充数据（比如1000）个任务
 * 消费者进行 并发读取，直至queue.isEmpty
 * 
 * @author zhoushaojun
 *
 */
public class CocurrentQueue {

	private ConcurrentLinkedQueue<Integer> queue = new ConcurrentLinkedQueue<Integer>();
	public CocurrentQueue(ConcurrentLinkedQueue<Integer> queue) {
		this.queue = queue;
	}
	public void offer() {
		for (int i = 0; i < 100; i++) {
			queue.offer(i);
		}
	}
	public static void main(String[] args) throws Exception {
		ConcurrentLinkedQueue<Integer> queue = new ConcurrentLinkedQueue<Integer>();
		ExecutorService executor = Executors.newFixedThreadPool(3);
		
		CocurrentQueue master = new CocurrentQueue(queue);
		master.offer();
		Controller.count = 2;
		Controller controller = new Controller();
		executor.submit(new ThreadControl(controller));
		executor.submit(new ConsumerZ("1", queue));
		executor.submit(new ConsumerZ("2", queue));
		
		controller.await();
		System.out.println("Main over ----");
		
	}
}

class ConsumerZ implements Runnable {
	private ConcurrentLinkedQueue<Integer> queue = new ConcurrentLinkedQueue<Integer>();
	private String id;

	public ConsumerZ(String id, ConcurrentLinkedQueue<Integer> queue) {
		this.queue = queue;
		this.id= id;
	}
	@Override
	public void run() {
		// TODO 自动生成的方法存根
		while(!queue.isEmpty()){
			System.out.println("consumer "+id+" "+queue.poll());
		}
		System.out.println("consumer "+id+" over");
		
		Controller.minus();
		System.out.println(Controller.count);
	}
}
class ThreadControl implements Runnable{
	private Controller controller;

	public ThreadControl(Controller controller) {
		this.controller = controller;
	}
	public void run() {
		try {
			while (true) {
				//Thread.sleep(2);
				System.out.println("--check--");
				if (Controller.count != 0)
					continue;
				controller.anotify();
				return;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}
			
	}
	
	
}
class Controller {
	public static int count;

	public static void minus() {
		count--;
	}
	public synchronized void await() throws InterruptedException{
		this.wait();
	}
	public synchronized void anotify(){
		this.notify();
	}
}
