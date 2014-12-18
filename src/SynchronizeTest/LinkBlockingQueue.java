package SynchronizeTest;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
/**
 * (1)LinkedBlockingDeque Ϊ����ʽ���У�put/take ģʽ
 *    ��������ʱ��put������
 *    ͬ�����п�ʱ��take������
 * @author zhoushaojun
 *
 */
public class LinkBlockingQueue {
  
	public static void blockingQueueTest(){
		Entity entity = new Entity();
		ExecutorService executor = Executors.newCachedThreadPool();
		executor.submit(new Producer("1", entity));
		executor.submit(new Producer("2", entity));
		executor.submit(new Consumer("1", entity));
		executor.submit(new Consumer("2", entity));
	}
	public static void main(String[] args) {
		blockingQueueTest();
	}
}
class Entity{
	private BlockingDeque<String> block = new LinkedBlockingDeque<String>(3);
	
	public void produce(String id) throws InterruptedException{
		block.put("apple "+ id);
	}
	public String consume() throws InterruptedException{
		return block.take();
	}
}
class Producer implements Runnable{
	private String id;
	private Entity entity;
	public Producer(String id,Entity entity) {
		this.id= id;
		this.entity = entity;
	}
	public void run() {
		int i = 1;
		try {
			while(true){
		         System.out.println("������ : "+id+" -- ׼������ƻ��  "+String.valueOf(i));
	             entity.produce("������ "+id+" "+String.valueOf(i++));
	             Thread.sleep(1000);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
class Consumer implements Runnable{
	private String id;
	private Entity entity;
	public Consumer(String id,Entity entity) {
		this.id= id;
		this.entity = entity;
	}
	public void run() {
		int i = 1;
		try {
			while(true){
	             System.out.println("������ :"+id+" -- "+entity.consume());
	             Thread.sleep(2000);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}