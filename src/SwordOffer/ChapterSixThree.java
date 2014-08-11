package SwordOffer;

public class ChapterSixThree {
	
	public static int[] data = {1,3,3,3,3,3,4,5,6,7,8};
	public static int min = -1;
	public static int max = -1;
	
	public static void queryCountOfSameNum(int[] dataInner,int start,int end){
		if(start > end || start < 0 || end < 0) return;
		int mid =(end - start)>>1;
		mid =  start+ mid;
		if(min == -1 && dataInner[start] == 3){
			min = start;
			//return;
		}
		if(max == -1 && dataInner[end] == 3){
			max = end;
			//return;
		}
		if(start != end){
		queryCountOfSameNum(dataInner, start, mid);
		queryCountOfSameNum(dataInner, mid+1, end);
		}
	}
	public static void main(String[] args) {
		queryCountOfSameNum(ChapterSixThree.data, 0, ChapterSixThree.data.length-1);
		System.out.println(min);
		System.out.println(max);
	}
}
