package com.interview.swordoffer;

public class TreeUtil {
	
	private  static TreeNodeU root = null;
	static{
		root = new TreeNodeU("1");
		TreeNodeU two = new TreeNodeU("2");
		TreeNodeU three = new TreeNodeU("3");
		root.setLeft(two);
		root.setRight(three);
		
		TreeNodeU four = new TreeNodeU("4");
		TreeNodeU five = new TreeNodeU("5");
		two.setLeft(four);
		two.setRight(five);
		
		TreeNodeU six = new TreeNodeU("6");
		TreeNodeU seven = new TreeNodeU("7");
		three.setLeft(six);
		three.setRight(seven);
		
		TreeNodeU eight = new TreeNodeU("8");
		four.setLeft(eight);
	}
	public TreeUtil() {
		
	}

	public static TreeNodeU getRoot() {
		return root;
	}
}
class TreeNodeU {
	private String value;
	private TreeNodeU left;
	private TreeNodeU right;
	private TreeNodeU nextNode;
	private TreeNodeU frontNode;
	public TreeNodeU(String str) {
		this.value = str;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public TreeNodeU getLeft() {
		return left;
	}

	public void setLeft(TreeNodeU left) {
		this.left = left;
	}

	public TreeNodeU getRight() {
		return right;
	}

	public void setRight(TreeNodeU right) {
		this.right = right;
	}

	public TreeNodeU getNextNode() {
		return nextNode;
	}

	public void setNextNode(TreeNodeU nextNode) {
		this.nextNode = nextNode;
	}

	public TreeNodeU getFrontNode() {
		return frontNode;
	}

	public void setFrontNode(TreeNodeU frontNode) {
		this.frontNode = frontNode;
	}
	
}
