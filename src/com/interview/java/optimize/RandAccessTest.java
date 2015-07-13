package com.interview.java.optimize;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.lang.reflect.Method;
import java.nio.IntBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
/**
 * （1） 随机访问类 的 读写测试
 * （2） 内存映射的读写测试
 * @author zhoushaojun
 *
 */
public class RandAccessTest {
	public static void write() {
		RandomAccessFile raf = null;
		try {
			// 创建一个可读写的对象
			raf = new RandomAccessFile("D:\\raf.dat", "rw");
			// 写入数据。 可直接操作指定基本数据类型的对象。
			raf.writeInt(10);
			//raf.writeInt(Integer.MAX_VALUE);
			 raf.writeUTF("zho周");
			// raf.writeChars("leng竟 的d");
			// raf.writeChars("java");
			// raf.writeChars("hello world");
			// raf.writeBytes("java hello");

			// raf.writeBytes("where are you");
			//raf.writeInt(22);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (raf != null)
					raf.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void read() {
		RandomAccessFile raf = null;
		try {
			// 创建一个随机访问对象，且文件的访问模式为只读。
			// 注意，一旦模式为只读，就不对其进行写入操作。
			raf = new RandomAccessFile("D:\\raf.dat", "r");
			// 文件只读模式，写入操作将抛异常
			// raf.write("datou".getBytes());
			// 可直接操作指针，灵活的访问内容
			// int value = raf.readInt();
			// System.out.println(value);
			raf.readInt();
			byte b[] = new byte[10];
			String content = raf.readUTF();
			System.out.println(content);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (raf != null)
					raf.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void bufferWrite() throws IOException {
		RandomAccessFile raf;
		try {
			raf = new RandomAccessFile("D:\\raf.dat", "rw");
			FileChannel fc = raf.getChannel();
			MappedByteBuffer mappedByteBuffer = fc.map(FileChannel.MapMode.READ_WRITE, 0, 8);
			// CharBuffer charBuffer = mappedByteBuffer.asCharBuffer();
			// charBuffer.put("周绍钧");
			// charBuffer.put("leng");
			IntBuffer intBuffer = mappedByteBuffer.asIntBuffer();
			intBuffer.put(10);
			intBuffer.put(Integer.MAX_VALUE);
			fc.close();
		} catch (FileNotFoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}

	}

	public static void bufferMap() {
		try {
			RandomAccessFile raf = new RandomAccessFile("D:\\raf.dat", "rw");
			FileChannel fc = raf.getChannel();
			MappedByteBuffer mappedByteBuffer = fc.map(FileChannel.MapMode.READ_WRITE, 0, raf.length());

			// IntegerBuffer Test
			IntBuffer ib = mappedByteBuffer.asIntBuffer();
			while (ib.hasRemaining()) {
				System.out.println(ib.get());
			}

			// CharBuffer cBuffer = mappedByteBuffer.asCharBuffer();
			// while (cBuffer.hasRemaining()) {
			// System.out.println(cBuffer.get());
			// }
			// cBuffer.rewind();
			// System.out.println(cBuffer.toString());

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}

	}

	private String getStr(){
		return "lengjing";
	}
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws  Exception{
		 //RandAccessTest.write();
		 //RandAccessTest.read();
		RandAccessTest.bufferWrite();
		RandAccessTest.bufferMap();
	}
}
