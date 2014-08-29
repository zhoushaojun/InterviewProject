package JavaOptimize;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

public class RandAccessTest {

	public static void write() {
		RandomAccessFile raf = null;
		try {
			// 创建一个可读写的对象
			raf = new RandomAccessFile("D:\\raf.dat", "rw");
			// 写入数据。 可直接操作指定基本数据类型的对象。
			raf.writeInt(12345);
			raf.writeBytes("java hello");
		
			raf.writeBytes("where are you");
			raf.writeInt(22);
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
//			int value = raf.readInt();
//			System.out.println(value);
			raf.seek(4);
			byte b[] = new byte[10];
			raf.read(b);
			//System.out.println(new String(b));
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

	public static void bufferMap(){
		try {
			RandomAccessFile raf = new RandomAccessFile("D:\\raf.dat", "rw");
			FileChannel fc = raf.getChannel();
			MappedByteBuffer mappedByteBuffer = fc.map(FileChannel.MapMode.READ_WRITE,0, raf.length());
			
			int value = mappedByteBuffer.getInt();
				System.out.println(value);
				byte[] byts = new byte[10];
				ByteBuffer bf = mappedByteBuffer.get(byts);
				System.out.println(new String(byts));
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
	}
	public static void main(String[] args) {
		RandAccessTest.write();
		RandAccessTest.read();
		RandAccessTest.bufferMap();
	}
}
