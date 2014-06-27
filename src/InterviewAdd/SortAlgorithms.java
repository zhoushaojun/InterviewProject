package InterviewAdd;

import java.net.Inet4Address;

public class SortAlgorithms {

	public int[] data = {1,5,47,87,56,24,8,2,34,7,5,8,9};
	
	public void bubbleSort(){
		
		int size =  data.length;
		for(int i=0; i< size;i++ ){
			for(int j= size-1;j>=i;j--){
				
				if(j-1 >=0 &&data[j]<data[j-1]){
					data[j] = data[j] + data[j-1];
					data[j-1] = data[j]-data[j-1];
					data[j] = data[j]-data[j-1];
				}
			}
		}//for end
		printf();
	}

	public void quickSort(int[] data,int start,int end){
		
		if(start >= end)return;
		int startInner = start;
		int endInner = end;
		int pivot = data[startInner];
		while(startInner < endInner){
			  //notice the condition of while 2conditions
			  while(data[endInner]>= pivot && startInner < endInner) endInner--;
			  if(startInner < endInner)data[startInner++]=data[endInner];
			  while(data[startInner]<= pivot && startInner < endInner)startInner++;
			  if(startInner < endInner)data[endInner--]=data[startInner];
		}
		if(startInner == endInner){
			data[startInner] = pivot;
			quickSort(data, start, startInner-1);
			quickSort(data, startInner+1,end);
			
		}
		
	}
	
	public void twoIntegreate(int []data,int start,int end){
		if(start >= end) return;
		int mid = (start+end)/2;
		//System.out.println(start+" "+end);
		twoIntegreate(data, start, mid);
		twoIntegreate(data, mid+1, end);
		twoInnerForIntegrateData(data, start, mid, end);
	}
	public void twoInnerForIntegrateData(int[]data,int start,int mid,int end){
		int size = end -start +1;
		int []temp = new int[size];
		int first=start,second=mid+1;
		int cur =0;
		while(first<=mid && second <= end){
			if(data[first] < data[second])
				temp[cur++]= data[first++];
			else {
				temp[cur++]= data[second++];
			}
			
		}
		if(first <= mid){
			while(first <= mid)
				temp[cur++]= data[first++];
		}
		if(second <= end){
			while(second <= mid)
				temp[cur++]= data[second++];
		}
		//Notice the use of arraycopy
		System.arraycopy(temp,0,data, start,cur);
	}
	
	
	public void heapSort(int []data){
		int length = data.length;
		for(int i = length-1/2;i>=0;i--){
		    heapAdjust(data, i, data.length);	
		}
		for(int i=length-1;i>=0;i--){
			data[i]=data[i]+data[0];
			data[0]=data[i]-data[0];
			data[i]=data[i]-data[0];
			heapAdjust(data, 0, i);
			
		}
	}
	public void heapAdjust(int[]data,int start,int length){
		while(start*2+1 < length){
			
			int maxIndex = start*2+1;
			if(start*2+2 < length){
				if(data[start*2+2] > data[start*2+1])
					maxIndex = start*2+2;
			}
			if(data[start] >  data[maxIndex]) break;
			else{
				data[start]= data[start]+data[maxIndex];
				data[maxIndex]=data[start]-data[maxIndex];
				data[start]=data[start]-data[maxIndex];
				start = maxIndex;
				continue;
				
			}
		}
	}
	
	public void printf(){
		 for (int element : data) {
			System.out.println(element);
		}
	}
	public static void main(String[] args) {
		SortAlgorithms sort = new SortAlgorithms();
		//sort.bubbleSort();
		//sort.quickSort(sort.data, 0,sort.data.length-1);
		//sort.twoIntegreate(sort.data, 0,sort.data.length-1);
		sort.heapSort(sort.data);
		sort.printf();
//		int []dat1= {1,2,3,4,5};
//		int []dat2= {6,7,8,9,10,11,12};	
//		System.arraycopy(dat1,0, dat2, 2, 3);
//		for (int i : dat2) {		
//			System.out.println(i);
//		}
//		
	}
}
