package SwordOffer;

/**
 * 大数打印，当题目没有提到数值限制比如n，这时候需要注意大数问题。
 *  Ps：(a+b)/2 应该换成 a+ (abs(a-b))/2;
 * 
 * 注意：   char 之间运算 '6'-'0'= 6(int) 
 * 		如果需要int 转换为char , char(int+'0')
 * 
 * @author zhoushaojun
 * 
 */
public class BigNumberPrint {
	private static int size = 6;
	private static char[] data = new char[size];
	static {
		for (int i = 0; i < size; i++) {
			data[i] = '0';
		}
	}

	public static void bigCoreAddOne() throws Exception {
		int length = data.length;
		int sum = 0;
		int takeOver = 0;

		for (int i = length - 1; i >= 0; i--) {
			sum = (data[i] - '0') + takeOver;
			if (i == length - 1) {
				sum++;
			}
			if (sum == 10) {
				if (i == 0) {
					System.out.println("Overflow");
					throw new Exception();
				}
				data[i] = '0';
				takeOver = 1;
				continue;
			} else {
				data[i] = (char) (sum + '0');
				break;
			}
		}
		printf();
	}

	private static void printf() {
		StringBuilder builder = new StringBuilder();
		for (char e : data) {
			// if (e != '0') {
			builder.append(e);
			// }
		}
		System.out.println(builder.toString().trim());
	}

	public static void main(String[] args) {
	/*	try {
			for (int i = 0; i < 100000000; i++) {
				bigCoreAddOne();
			}
		} catch (Exception e) {
			System.out.println("over");
		}
		System.out.println(Integer.MAX_VALUE);
		*/
	 BigNumberCursive.bigCursive(0);
	}
}

/**
 * 通过 递归方式进行 进行大数打印。 实质：为全排列模式。
 *  （1）任意一个元素均不能重复 全排列 参考 AllSortOfArray.java 文件
 *		 通过当前元素后一个继续递归，当前元素与后面每个元素交换，并在递归后交换回来。递归点就是当前元素 index+1
 *  （2）任意元素可以重复，通过每一个元素10之内进行循环。递归点则是当前index+1
 * 
 * @author zhoushaojun
 * 
 */
class BigNumberCursive {
	private static int length = 6;
	private static char[] data = new char[6];

	static {
		for (int i = 0; i < length; i++) {
			data[i] = '0';
		}
	}

	public static void bigCursive(int index) {
		if (index == length) {
			printf();
			return;
		}
		for (int i = 0; i < 10; i++) {
			data[index] = (char)(i+'0');
			bigCursive(index+1);
		}

	}
	private static void printf() {
		StringBuilder builder = new StringBuilder();
		for (char e : data) {
			builder.append(e);
		}
		System.out.println(builder.toString().trim());
	}

}
