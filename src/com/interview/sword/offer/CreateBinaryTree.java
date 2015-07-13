package com.interview.sword.offer;
/**
 * ����ǰ������������ �ع���������
 * ǰ������Ϊ ���ڵ㿪ʼ��Ŀ¼����������������ǰ������������ �������� �ָ�ݹ�ѭ��
 * @author zhoushaojun
 *
 */
public class CreateBinaryTree {

	private static int[] front = { 1, 2, 4, 7, 5, 3, 6 };

	private static int[] middle = { 7, 4, 2, 5, 1, 6, 3 };

	private static int frontIndex = 0;

	public static int getMiddleLength() {
		if (null != middle) {
			return middle.length;
		} else {
			return -1;
		}
	}

	public static TreeNodeU createCore(TreeNodeU root, int midStart, int midEnd) throws Exception {
		// [0]�������
		if (null == root || midStart < 0 || midEnd < 0 || midStart > midEnd || frontIndex < 0) {
			throw new Exception();
		}
		if (frontIndex >= front.length) {
			return null;
		}
		// [1]��ȡǰ����������ע��ÿ�β�ȡ�����frontIndex++����֤ÿ��ʹǰ������� ǰ��
		int pivot = front[frontIndex++];
		int midFind = -1;

		// [2]������������� ǰ������� ���ڵ�
		for (int i = midStart; i <= midEnd; i++) {
			if (middle[i] == pivot) {
				midFind = i;
				break;
			}
		}
		// [3]�������������� ������
		root.setValue(String.valueOf(pivot));
		if (midFind != midStart) {
			root.setLeft(createCore(new TreeNodeU("left"), midStart, midFind - 1));
		}

		if (midFind != midEnd) {
			root.setRight(createCore(new TreeNodeU("right"), midFind + 1, midEnd));
		}
		return root;
	}

	public static void readTree(TreeNodeU root) {
		if (null == root) {
			return;
		}

		readTree(root.getLeft());
		System.out.println(root.getValue());
		readTree(root.getRight());

	}

	public static void main(String[] args) {
		TreeNodeU root = new TreeNodeU("startNode");
		try {
			createCore(root, 0, getMiddleLength() - 1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// System.out.println(root.getValue());
		readTree(new TreeNodeU("3"));

	}
}
