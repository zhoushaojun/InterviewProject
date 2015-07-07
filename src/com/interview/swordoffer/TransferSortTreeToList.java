package com.interview.swordoffer;
/**
 * 将二叉排序树 转化为  双向链表
 * 二叉排序树的中序遍历结果 ： 已经为正确的递增排序，因此只要处理中序遍历结果即可。
 * left->value->right
 * 但是中序遍历结果 只是打印出当前的节点，而无法记录前后节点的关系。保存一个全局变量
 * current,每次处理完当前节点，将current=tree。从而依次记录最后一个节点。
 * @author zhoushaojun
 *
 */
public class TransferSortTreeToList {
	
	public static TreeNodeU current ;
	public static void handleCore(){
		TreeNodeU root = TreeUtil.getRoot();
		TreeNodeU starTreeNodeU = current;
		transferCore(root);
		
		//打印结果
		System.out.println(starTreeNodeU);
		while(null != current){
			System.out.println(current.getValue());
			current= current.getFrontNode();
		}
	}

	private static void transferCore(TreeNodeU tree) {
		if (null == tree) {
			return;
		}
		if (null != tree.getLeft()) {
			transferCore(tree.getLeft());
		}
		if (null != current) {
			current.setNextNode(tree);
			tree.setFrontNode(current);
		}
		current = tree;
		
		if (null != tree.getRight()) {
			transferCore(tree.getRight());
		}
	}
	public static void main(String[] args) {
		handleCore();
	}
}
