package SwordOffer;

import javax.xml.stream.events.EndDocument;

/**
 * （1）此方法利用 快速排序方法中， 制定第一个元素 ，所有 少于第一个元素 在左边，所以大于一个元素的在右边。
 * 一直找到 第 4 个元素，这样左边的元素 是最少的4个元素
 * （2）另外一种方法 package InterviewCase.Get_min_value_use_heapsort
 *  利用堆排序 建堆 过程中，找出最少4个元素
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
	 * 直接返回 数组中， 中间元素，左边少于 右边大于
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
