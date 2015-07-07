package com.interview.interviewcase2;

import java.util.ArrayList;
/**
 * Ê÷ ²ã´Î±éÀú
 * @author zhoushaojun
 *
 */
public class LevelForTree {

	public TreeNode root = new TreeNode(100);

	public LevelForTree() {

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

	public void treeLevelRead(TreeNode node, int level) {
		if (level == 1) {
			if (null != node)
				System.out.println(node.value);
			// [2]return 1;
			return;
		}
		if (level < 1)
			return;
		treeLevelRead(node.left, level - 1);
		treeLevelRead(node.right, level - 1);
		// [2]return 1;
		// [2]return treeLevelRead(node.left, level-1)+treeLevelRead(node.right,
		// level-1);
	}

	public void treeLevelReadNonLoop() {
		ArrayList<TreeNode> data = new ArrayList<TreeNode>();
		data.add(root);
		int cur = 0, end = 1;
		while (cur < data.size()) {
			// [1] configure for end
			end = data.size();
			while (cur < end) {
				TreeNode node = data.get(cur);
				if (null != node) {
					System.out.println(node.value);
					data.add(node.left);
					data.add(node.right);
					cur++;
				}
			}
		}// while end
	}

	public static void main(String[] args) {
		LevelForTree tree = new LevelForTree();

		// tree.treeLevelRead(tree.root, 3);
		// for(int i=1;i<=3;i++){
		// System.out.println("level "+i);
		// tree.treeLevelRead(tree.root,i);
		// }
		tree.treeLevelReadNonLoop();
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
