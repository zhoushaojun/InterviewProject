package JavaOptimize;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.lang.reflect.Method;
import java.nio.IntBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
/**
 * ��1�� ��������� �� ��д����
 * ��2�� �ڴ�ӳ��Ķ�д����
 * @author zhoushaojun
 *
 */
public class RandAccessTest {
	public static void write() {
		RandomAccessFile raf = null;
		try {
			// ����һ���ɶ�д�Ķ���
			raf = new RandomAccessFile("D:\\raf.dat", "rw");
			// д�����ݡ� ��ֱ�Ӳ���ָ�������������͵Ķ���
			raf.writeInt(10);
			//raf.writeInt(Integer.MAX_VALUE);
			 raf.writeUTF("zho��");
			// raf.writeChars("leng�� ��d");
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
			// ����һ��������ʶ������ļ��ķ���ģʽΪֻ����
			// ע�⣬һ��ģʽΪֻ�����Ͳ��������д�������
			raf = new RandomAccessFile("D:\\raf.dat", "r");
			// �ļ�ֻ��ģʽ��д����������쳣
			// raf.write("datou".getBytes());
			// ��ֱ�Ӳ���ָ�룬���ķ�������
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
			// charBuffer.put("���ܾ�");
			// charBuffer.put("leng");
			IntBuffer intBuffer = mappedByteBuffer.asIntBuffer();
			intBuffer.put(10);
			intBuffer.put(Integer.MAX_VALUE);
			fc.close();
		} catch (FileNotFoundException e) {
			// TODO �Զ����ɵ� catch ��
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
			// TODO �Զ����ɵ� catch ��
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
