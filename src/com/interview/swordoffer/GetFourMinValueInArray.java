package com.interview.swordoffer;

import javax.xml.stream.events.EndDocument;

/**
 * ��1���˷������� �������򷽷��У� �ƶ���һ��Ԫ�� ������ ���ڵ�һ��Ԫ�� ����ߣ����Դ���һ��Ԫ�ص����ұߡ�
 * һֱ�ҵ� �� 4 ��Ԫ�أ�������ߵ�Ԫ�� �����ٵ�4��Ԫ��
 * ��2������һ�ַ��� package InterviewCase.Get_min_value_use_heapsort
 *  ���ö����� ���� �����У��ҳ�����4��Ԫ��
 * @author zhoushaojun
 *
 */
public class GetFourMinValueInArray {

	private static int[] data = {7,8,6,4,5,2,54,1,0,87,19,20,3};
	
	public static void printf(){
		String content = "";
		for (int e : data) {
			content += e +" ";
		}
		System.out.println(content);
	}
	
	public static void calulateFourValue(int k){
		
		int index = 0;
		int start = 0;
		int end = data.length -1;
		index = getPartitionCore(start, end);
		while(index != k-1){
		
			if(index > k -1){
				end = index -1;
				index = getPartitionCore(start, end);
			}else {
				start = index + 1;
				index = getPartitionCore(start, end);
			}
		}
		
	}
	/**
	 * ֱ�ӷ��� �����У� �м�Ԫ�أ�������� �ұߴ���
	 * @param start
	 * @param end
	 * @return
	 */
	
	public static int getPartitionCore(int start,int end){
		
		if(start > end) return -1;
		int startInner = start;
		int endInner = end;
		int pivot = data[start];
		
		while(startInner < endInner){
			
			while(startInner< endInner && data[endInner] >= pivot){
				endInner--;
			}
			if(startInner< endInner ){
				data[startInner++] = data[endInner];
			}
			while(startInner< endInner && data[startInner] <= pivot){
				startInner++;
			}
			if(startInner< endInner ){
				data[endInner--]= data[startInner];
			}
		}
		
		if(startInner == endInner){
			data[startInner] = pivot;
			return startInner;
		}
		return -1;
	}
	public static void main(String[] args) {
		//System.out.println(getPartitionCore(0, data.length -1));
		//printf();
		
		calulateFourValue(4);
		printf();
	}
}
