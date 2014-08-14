package SwordOffer;

public class maxLengthOfTree {
	public Tree root = new Tree();
	public maxLengthOfTree() {
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
	public int getLengthOfTree(Tree tree){
		if(null == tree) return 0;
		
		int left = getLengthOfTree(tree.leftNext);
		int right = getLengthOfTree(tree.getRightNext());
		
		if(left == 0 && right == 0) return 1;
		if(left > right) return left +1;
		else return right + 1;
	}
	public static void main(String[] args) {
		maxLengthOfTree max = new maxLengthOfTree();
		int result = max.getLengthOfTree(max.root);
		System.out.println(result);
	}
}
class Tree {
	public Tree leftNext = null;
	public Tree rightNext = null;
	public String node = null;
	
	public Tree(){
		
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
