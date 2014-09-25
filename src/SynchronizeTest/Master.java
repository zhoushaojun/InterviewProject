package SynchronizeTest;

import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
/**
 * 
 * @author zhoushaojun && lengjing
 *  smart
 *
 */
public class Master {

	private ConcurrentLinkedQueue<Object>     workQueue = new ConcurrentLinkedQueue<Object>();
	private ConcurrentHashMap<String, Object> result    = new ConcurrentHashMap<String,Object>();
	private ConcurrentHashMap<String,Thread>  threads   = new ConcurrentHashMap<String,Thread>();
	
	public Master(Worker work,int count) {
		work.setWorkQueue(workQueue);
		work.setMapResult(result);
		for(int i=0;i<count;i++){
			threads.put(Integer.toString(i),new Thread(work,Integer.toString(i)));
			
		}
	}
	public boolean isCompleted(){
		for( Map.Entry<String, Thread>  entry: threads.entrySet()){
			 if(entry.getValue().getState() != Thread.State.TERMINATED)
				 return false;
		}
		return true;
	}
	
	public void submitWork(Object obj){
		this.workQueue.add(obj);
	}
	public void execute(){
		for(Map.Entry<String, Thread> entry: threads.entrySet()){
			entry.getValue().start();
		}
		
	}
	public Map<String,Object> getResult(){
		return result;
	}
	
	public static void main(String[] args) {
		
		Master master = new Master(new Worker(),5);
		for(int i=1 ;i<10;i++)
			master.submitWork(i);
		master.execute();
		Map<String,Object> result = master.getResult();
		int total = 0;
		/**According to the size of workqueue
		 * KEY 2: The main thread supervise the size of resultmap and signal of thread 
		 * 		  if master cannot get result from resultmap and all thread terminate,
		 * 		  then it will show result and quit
		 */
		while(result.size() >0 || !master.isCompleted()){
			if(result.size() != 0)
			System.out.println("leng "+ result.size());
			Set<String> keys = result.keySet();
			String key = null;
			for (String string : keys) {
				key = string;
				break;
			}
			int value = 0;
			if(null != key){
				value = (Integer)result.get(key);
				result.remove(key);
			}
			//System.out.println("value "+value);
			total += value;
			//System.out.println("total "+total);
			if(result.size() > 0)
			System.out.println(result.size()+ " " +String.valueOf(!master.isCompleted()));
		}
		System.out.println(total);
		
	}
}
class Worker implements Runnable{
	private Queue<Object> workQueue = null;
	private Map<String,Object> result = null;
	public void run() {
		while(true){
			if(null != workQueue){
				Object obj = workQueue.poll();
				/**According to the size of workqueue
				 * KEY 1: Every thread try to get work from workqueue 
				 * 		  if thread can not get null means it does not have work in workqueue
				 * 		  so thread can quit.
				 */
				if(null == obj) {
					System.out.println("Thread stop");
					Thread.currentThread().stop();
				}
				if(obj != null){
				Integer value = (Integer)obj * (Integer)obj;
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("Thread is running "+Thread.currentThread().getName()+" "+value);
				result.put(Integer.toString(value.hashCode()), value);
				}
			}
		}
		
	}
	public void setWorkQueue(Queue<Object> work){
		this.workQueue = work;
	}
	public void setMapResult(Map<String, Object> res){
		this.result =res;
	}
	
}
