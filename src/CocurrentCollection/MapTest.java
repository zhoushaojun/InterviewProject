package CocurrentCollection;

import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.locks.ReentrantLock;

public class MapTest {
	private static LinkedHashMap<String, String> lHashMapPut = new LinkedHashMap<String, String>(16,0.75f, false);
	private static LinkedHashMap<String, String> lHashMapRead = new LinkedHashMap<String, String>(16,0.75f, true);
	
	public static void  lhashmapPutTest(){
		lHashMapPut.put("1", "a");
		lHashMapPut.put("2", "b");
		lHashMapPut.put("3", "c");
		
		lHashMapPut.get("1");
		
		readMap(lHashMapPut);
	}
	
	
	public static void  lhashmapReadTest(){
		lHashMapRead.put("1", "a");
		lHashMapRead.put("2", "b");
		lHashMapRead.put("3", "c");
		
		lHashMapRead.get("2");
		
		readMap(lHashMapRead);
		
	}
	
	public static void readMap(LinkedHashMap< String,String> map){
		Set<Entry<String, String>> keys = map.entrySet();
		for (Entry<String, String> entry : keys) {
			System.out.println(entry.getKey());
			System.out.println(entry.getValue());
		}
	}
	
	public static void main(String[] args) {
		//lhashmapPutTest();
		lhashmapReadTest();
		
		Object obj = new Long(100);
		System.out.println(obj.toString());
	}
}
