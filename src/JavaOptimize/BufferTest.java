package JavaOptimize;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;

public class BufferTest {
	
	private static CharBuffer buffer = CharBuffer.allocate(1024);
	public static void getTest(){
		for (int i = 0; i < 10; i++) {
			buffer.put('w');
		}
		buffer.flip();
		char[] data = new char[4];
		buffer.get(data);
		for (char b : data) {
			System.out.println(b);
		}
		data[0]= 1;
		data[1]= 1;
		data[2]= 1;
		data[3]= 1;
		buffer.flip();
		buffer.put(data);
	}
	public static void printf(){
		System.out.println("postion : "+buffer.position());
		System.out.println("limit : "+buffer.limit());
		System.out.println("capacity : "+buffer.capacity());
	}
	public static void main(String[] args) {
		BufferTest.getTest();
		BufferTest.printf();
		String string = "java hello";
		System.out.println(string.getBytes().length);
		
	}
}
