package SwordOffer;
/**
 * ����Ԫ�ص�ȫ����
 * ��1��һ��ȫ������
 * ��2��ÿ�ηֳ�2���� a | bcd  b|cd c|d ���ģʽ
 * ��3��ÿ�εݹ�ǰ���� Ȼ�� �ݹ����� �ٴεݹ�ָ�
 * ��4��ÿ�εݹ鿪ʼstart+1,�������Ƿ񻥻�
 * 
 * @author zhoushaojun
 *
 */
public class AllSortOfArray {
	public static String[] data = {"a","b","c"};
	
	public static void calAllSort(int start,int length){
		if(start >= length ){
			StringBuilder builder = new StringBuilder();
			for (String str : data) {
				builder.append(str+" -> ");
			}
			System.out.println(builder.toString());
		}
		//System.out.println(start+" "+length);
		int originalStart = start;
		String temp;
		//���� �ڵݹ�ǰ ���� ������ÿ�ν��еݹ���� ���л�������������ֵ����˳�򲻱�
		for(int i= start;i< length;i++){
			temp = data[originalStart];
			data[originalStart] = data[i];
			data[i] = temp;
		
			//����ǳ���Ҫ��ÿ��ѭ���� a | b c,��start+1 ����1��ʼ������ b c �������� start+1
			calAllSort(start+1, length);
			
			temp = data[originalStart];
			data[originalStart] = data[i];
			data[i] = temp;
		}
	}
	public static void main(String[] args) {
		calAllSort(0, data.length);
		for (String string : data) {
			System.out.println(string);
			
		}
	}
}
