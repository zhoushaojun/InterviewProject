package com.interview.javaoptimize;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
/**
 * 
 * @author zhoushaojun
 *  rewind use to read : position -> 0 ; limit don't move
 *  clear  use to write : position - > 0; limit -> capacity
 *  flip   use read write transfer : postion -> 0; limit -> position
 */
public class BufferTest {
	
	private static CharBuffer buffer = CharBuffer.allocate(1024);
	public static void getTest(){
		for (int i = 0; i < 10; i++) {
			buffer.put('w');
		}
		//[1] rewind make position to 0, use to read
		buffer.rewind();
		char[] data = new char[4];
		buffer.get(data);
		for (char b : data) {
			System.out.println(b);
		}
		
		//flip postion -> 0 limit->position : use read and write transfer
		buffer.rewind();
		buffer.put(0,'1');
		buffer.put(1,'2');

		buffer.rewind();
		for (int i = 0; i < 10; i++) {
			System.out.println(buffer.get(i));
		}
	}
	public static void printf(){
		System.out.println("postion : "+buffer.position());
		System.out.println("limit : "+buffer.limit());
		System.out.println("capacity : "+buffer.capacity());
	}
	public static void main(String[] args) {
		BufferTest.getTest();
		//BufferTest.printf();
		//String string = "java hello";
		//System.out.println(string.getBytes().length);
		
	}
}
