package SwordOffer;
/**
 * ������������ ת��Ϊ  ˫������
 * ���������������������� �� �Ѿ�Ϊ��ȷ�ĵ����������ֻҪ�����������������ɡ�
 * left->value->right
 * �������������� ֻ�Ǵ�ӡ����ǰ�Ľڵ㣬���޷���¼ǰ��ڵ�Ĺ�ϵ������һ��ȫ�ֱ���
 * current,ÿ�δ����굱ǰ�ڵ㣬��current=tree���Ӷ����μ�¼���һ���ڵ㡣
 * @author zhoushaojun
 *
 */
public class TransferSortTreeToList {
	
	public static TreeNodeU current ;
	public static void handleCore(){
		TreeNodeU root = TreeUtil.getRoot();
		TreeNodeU starTreeNodeU = current;
		transferCore(root);
		
		//��ӡ���
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
