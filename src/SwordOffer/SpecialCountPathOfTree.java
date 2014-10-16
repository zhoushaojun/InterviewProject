package SwordOffer;

import java.util.ArrayList;
import java.util.Stack;

/**
 * �������ϵĺ�Ϊĳһ��ֵ�� ����·����
 *  (1)��ǰ�ڵ��sum ��ֵ��һֱ���� ���ݣ����������ÿ�εݹ��� �Ǿֲ�����������ڲ��ı䲻Ӱ������ �ڵ�2
 * �ָ������� ���´���ͬʱ������ �õ�������� ��ֵ
 *  (2) stack �Ĳ�����Ӱ���������򡣴Ӹ��ڵ㵽 Ҷ�ӽڵ�һֱ ���棬Ҷ�ӽڵ㴦������� ɾ��
 * ����һ���ڵ㣬Ҳ���ǸղŴ����Ҷ�ӽڵ㡣
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
		
		// �ж� Ҷ�ӽڵ� ���ҵ��� sum �Ѿ�Ϊ lastsum
		if (sum == lastSum && isLeaf) {
			StringBuilder builder = new StringBuilder();
			for (TreeNodeU treeNodeU : stack) {
				builder.append(treeNodeU.getValue() + " -> ");
			}
			System.out.println(builder.toString());
		}

		// �������� ��������
		getSpecialNumberofTree(node.getLeft(), sum, lastSum, stack);
		getSpecialNumberofTree(node.getRight(), sum, lastSum, stack);

		stack.remove(node);
	}

	public static void main(String[] args) {
		handleCore();
	}
}
