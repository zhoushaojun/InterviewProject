package com.interview.sword.offer;

import java.util.LinkedList;
import java.util.Queue;
/**
 * ���ľ��� && ��α���
 * @author zhoushaojun
 *
 */
public class MirrorTree {
	public static TreeNode root = new TreeNode(100);
	public static Queue<TreeNode> queue = new LinkedList<TreeNode>();

	public MirrorTree() {
		TreeNode twoleft = new TreeNode(1);
		TreeNode tworight = new TreeNode(2);
		TreeNode threeleft = new TreeNode(3);
		TreeNode threeright = new TreeNode(4);
		TreeNode fourleft = new TreeNode(5);
		TreeNode fourright = new TreeNode(6);
		root.left = twoleft;
		root.right = tworight;
		twoleft.left = threeleft;
		twoleft.right = threeright;
		tworight.left = fourleft;
		tworight.right = fourright;
	}

	/**
	 * ���ľ��񣬲�ȡ�����������ȶ�ȡ������������������󽻻� ���ҵ���ֵ
	 * @param node
	 */
	public void mirrorTree(TreeNode node) {
		if (null == node)
			return;
		if (node.left == null && node.right == null)
			return;
		mirrorTree(node.left);
		mirrorTree(node.right);
		TreeNode temp = node.left;
		node.left = node.right;
		node.right = temp;
	}

	/**
	 * ��α��� �� ���ö��� �Ƚ��ȳ�����ȡһ��Ԫ�ء��������Ԫ����������
	 */
	public static void levelForTree() {
		queue.offer(root);
		while (queue.size() != 0) {
			TreeNode node = queue.poll();
			System.out.println(node.value);
			if (node.left != null)
				queue.offer(node.left);
			if (node.right != null)
				queue.offer(node.right);
		}

	}

	public static void main(String[] args) {
		MirrorTree mirror = new MirrorTree();
		mirror.levelForTree();
		mirror.mirrorTree(root);
		System.out.println("--------------");
		mirror.levelForTree();
	}
}

class TreeNode {

	public int value = 0;
	public TreeNode left = null;
	public TreeNode right = null;

	public TreeNode(int va) {
		this.value = va;
	}
}