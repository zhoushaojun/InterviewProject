package SwordOffer;
/**
 * 根据前序、中序遍历结果 重构二叉树。
 * 前序结果作为 根节点开始的目录，中序遍历结果根部前序遍历结果进行 左右子树 分割递归循环
 * @author zhoushaojun
 *
 */
public class createBinaryTree {

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
		// [0]条件检测
		if (null == root || midStart < 0 || midEnd < 0 || midStart > midEnd || frontIndex < 0) {
			throw new Exception();
		}
		if (frontIndex >= front.length) {
			return null;
		}
		// [1]获取前序遍历结果，注意每次采取后必须frontIndex++。保证每次使前序遍历均 前进
		int pivot = front[frontIndex++];
		int midFind = -1;

		// [2]查找中序遍历中 前序遍历的 根节点
		for (int i = midStart; i <= midEnd; i++) {
			if (middle[i] == pivot) {
				midFind = i;
				break;
			}
		}
		// [3]继续查找左子树 右子树
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
