package com.interview.interview.case2;
/**
 * 数组的子数组之和最大值
 * 最大递增子序列，连续子序列的和值最大
 * @author zhoushaojun
 *
 */
public class MaxSubsequence {
   
	private int[] data = {1,2,-3,4,-4};
	public void getData(){
		
	    int size = data.length;
	    int max  = 0;
	    int sum  = 0;
	    int start = -1,end = -1;
	    for( int i = 0; i < size-1 ; i++){
	    	sum = 0;
	    	for(int j = i; j < size; j++){
	    		sum += data[j];
	    		if(sum >= max){
	    			max = sum;
	    			start = i;
	    			end   = j;
	    		}
	    	}
	    }
		System.out.println(start + "  "+end);
		
	}

	public void getData2(){
		
		int size = data.length;
		int sum = 0;
		int start = 0,end = 0;
		int max = 0;
		for(int i = 0; i < size; i++){
			sum += data[i];
			if(sum <= 0){
				if(i+1 < size)
				start = i + 1;
				continue;
			}
			if(sum >= max){
				max = sum;
				end = i;
			}
		}
		System.out.println(start+" "+end);
	}
	public static void main(String[] args) {
		MaxSubsequence subsequence  = new MaxSubsequence();
		subsequence.getData2();
	}
}
