package com.interview.sword.offer;

import java.util.Stack;
/**
 * �ж�һ������ �Ƿ�Ϊ ջ�Ķ�ȡ����
 * originalStack Ϊջ
 * originalSequence  ��ջ����
 * readSequece ��ȡջ��˳��
 * �ж� readSequece �Ķ�ȡջ˳�� �Ƿ���� originalSequence��ջ��˳��
 * ͨ���ж�pReadStart < pReadEnd ��ȡ�����Ƿ��ȡ��ϣ����ڽ����ж�peek �� readSequence[pReadStart]
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
