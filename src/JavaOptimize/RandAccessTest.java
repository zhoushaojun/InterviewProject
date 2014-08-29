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
			// ����һ���ɶ�д�Ķ���
			raf = new RandomAccessFile("D:\\raf.dat", "rw");
			// д�����ݡ� ��ֱ�Ӳ���ָ�������������͵Ķ���
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
			// ����һ��������ʶ������ļ��ķ���ģʽΪֻ����
			// ע�⣬һ��ģʽΪֻ�����Ͳ��������д�������
			raf = new RandomAccessFile("D:\\raf.dat", "r");
			// �ļ�ֻ��ģʽ��д����������쳣
			// raf.write("datou".getBytes());

			// ��ֱ�Ӳ���ָ�룬���ķ�������
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
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		
	}
	public static void main(String[] args) {
		RandAccessTest.write();
		RandAccessTest.read();
		RandAccessTest.bufferMap();
	}
}
