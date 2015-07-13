package com.interview.sword.offer;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 计算树上的和为某一数值的 所有路径。
 *  (1)当前节点的sum 数值会一直往下 传递，这个变量在每次递归中 是局部变量，因此内部改变不影响总体 节点2
 * 分给左子树 往下处理，同时右子树 得到是起父类的 数值
 *  (2) stack 的操作会影响整个程序。从根节点到 叶子节点一直 保存，叶子节点处理完成则 删除
 * 最有一个节点，也就是刚才处理的叶子节点。
 * 
 * @author zhoushaojun
 * 
 */
public class SpecialCountPathOfTree {

	public static void handleCore() {
		TreeNodeU root = TreeUtil.getRoot();
		getSpecialNumberofTree(root, 0, 11, null);
	}

	private static void getSpecialNumberofTree(TreeNodeU node, int sum, int lastSum, ArrayList<TreeNodeU> stack) {
		if (null == node || 0 == lastSum) {
			return;
		}
		if (null == stack) {
			stack = new ArrayList<TreeNodeU>();
		}
		sum += Integer.valueOf(node.getValue());
		stack.add(node);
		boolean isLeaf = (null == node.getLeft()) && (null == node.getRight());
		
		// 判断 叶子节点 并且但是 sum 已经为 lastsum
		if (sum == lastSum && isLeaf) {
			StringBuilder builder = new StringBuilder();
			for (TreeNodeU treeNodeU : stack) {
				builder.append(treeNodeU.getValue() + " -> ");
			}
			System.out.println(builder.toString());
		}

		// 继续左右 子树遍历
		getSpecialNumberofTree(node.getLeft(), sum, lastSum, stack);
		getSpecialNumberofTree(node.getRight(), sum, lastSum, stack);

		stack.remove(node);
	}

	public static void main(String[] args) {
		handleCore();
	}
}
