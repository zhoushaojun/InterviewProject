package com.interview.swordoffer;
/**
 * 二叉树的深度 以及 平衡二叉树
 * @author zhoushaojun
 *
 */
public class MaxLengthBalanceTree {
	public Tree root = new Tree();

	public MaxLengthBalanceTree() {
		Tree root1 = new Tree();
		Tree root2 = new Tree();
		root.setLeftNext(root1);
		root.setRightNext(root2);
		Tree root3 = new Tree();
		Tree root4 = new Tree();
		Tree root5 = new Tree();
		Tree root6 = new Tree();
		Tree root7 = new Tree();
		Tree root8 = new Tree();
		root1.setLeftNext(root3);
		root1.setRightNext(root4);
		root4.setRightNext(root5);
		root4.setLeftNext(root6);
		root6.setRightNext(root8);
		root2.setLeftNext(root7);
	}

	/**
	 * Get the length of the tree
	 * 
	 * @param tree
	 * @return
	 */
	public int getLengthOfTree(Tree tree) {
		if (null == tree)
			return 0;

		int left = getLengthOfTree(tree.leftNext);
		int right = getLengthOfTree(tree.getRightNext());

		return 1 + (left > right ? left : right);
	}

	/**
	 * Judge balance tree According the TreeLength function
	 * 
	 * @param args
	 */
	public boolean isBalanceTree(Tree root) {
		if (null == root)
			return true;

		int left = getLengthOfTree(root.leftNext);
		int right = getLengthOfTree(root.rightNext);

		if (Math.abs(left - right) > 1)
			return false;

		return isBalanceTree(root.leftNext) && isBalanceTree(root.rightNext);

	}

	/**
	 * Judge balance tree According the TreeLength Thinking
	 * 
	 * @param args
	 */
	public boolean isBalanceTreeThinking(Tree tree) {
		if (null == tree) {
			return true;
		}
		if (isBalanceTreeThinking(tree.leftNext) && isBalanceTreeThinking(tree.rightNext)) {
			int leftDepth = 0;
			int rightDepth = 0;
			if (null != tree.leftNext) {
				leftDepth = tree.leftNext.depth;
			}
			if (null != tree.rightNext) {
				rightDepth = tree.rightNext.depth;
			}
			if (Math.abs(leftDepth - rightDepth) <= 1) {
				tree.depth = 1 + (leftDepth > rightDepth ? leftDepth : rightDepth);
				return true;
			}
		}
		return false;

	}

	public static void main(String[] args) {
		MaxLengthBalanceTree max = new MaxLengthBalanceTree();
		// int result = max.getLengthOfTree(max.root);
		// boolean result = max.isBalanceTree(max.root);
		boolean result = max.isBalanceTreeThinking(max.root);
		System.out.println(result);
	}
}

class Tree {
	public Tree leftNext = null;
	public Tree rightNext = null;
	public String node = null;
	public int depth;

	public Tree() {

	}

	public int getDepth() {
		return depth;
	}

	public void setDepth(int depth) {
		this.depth = depth;
	}

	public Tree getLeftNext() {
		return leftNext;
	}

	public void setLeftNext(Tree leftNext) {
		this.leftNext = leftNext;
	}

	public Tree getRightNext() {
		return rightNext;
	}

	public void setRightNext(Tree rightNext) {
		this.rightNext = rightNext;
	}

	public String getNode() {
		return node;
	}

	public void setNode(String node) {
		this.node = node;
	}
}
