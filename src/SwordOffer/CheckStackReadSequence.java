package SwordOffer;

import java.util.Stack;
/**
 * 判断一个序列 是否为 栈的读取序列
 * originalStack 为栈
 * originalSequence  入栈序列
 * readSequece 读取栈的顺序
 * 判断 readSequece 的读取栈顺序 是否符合 originalSequence入栈的顺序，
 * 通过判断pReadStart < pReadEnd 读取数组是否读取完毕，在内进行判断peek 与 readSequence[pReadStart]
 * @author zhoushaojun
 *
 */
public class CheckStackReadSequence {

	private static Stack<Integer> originalStack = new Stack<Integer>();
	private static int[] readSequece = { 5, 4, 3, 2, 1 };
	private static int[] originalSequence = { 1, 2, 3, 4, 5 };

	public CheckStackReadSequence() {

	}

	public static boolean checkCore(int[] read, int[] original) {
		if (null == read || null == original) {
			return false;
		}
		if (read.length == 0 || original.length == 0) {
			return false;
		}

		int pOriStart = 0, pOriEnd = original.length;
		int pReadStart = 0, pReadEnd = read.length;
		while (pReadStart < pReadEnd) {
			while (originalStack.isEmpty() || originalStack.peek() != read[pReadStart]) {
				if (pOriStart >= pOriEnd)
					break;
				originalStack.add(original[pOriStart++]);
			}

			if (originalStack.peek() != read[pReadStart])
				break;

			originalStack.pop();
			pReadStart++;
		}

		if (originalStack.isEmpty() && (pReadStart == pReadEnd))
			return true;
		return false;
	}

	public static void main(String[] args) {
		boolean result = checkCore(readSequece, originalSequence);
		System.out.println(result);

	}
}
