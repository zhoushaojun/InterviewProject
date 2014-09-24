package SwordOffer;
/**
 * 一次性找出 最小 最大 位置
 * @author zhoushaojun
 *
 */
public class ChapterSixThree {
	
	public static int[] data = {1,3,3,3,3,3,4,5,6,7,8};
	public static int min = -1;
	public static int max = -1;
	
	/**
	 * 一次性找出 最小 最大 位置
	 * @param dataInner
	 * @param start
	 * @param end
	 */
	public static void queryCountOfSameNum(int[] dataInner,int start,int end){
		if(start >end || start < 0 || end < 0) return;
		System.out.println(start + " "+end);
		int mid =(end - start)>>1;
		mid =  start+ mid;
		if( dataInner[start] == 3 && (start < min || min == -1)){
			System.out.println("start : "+start);
			min = start;
			//return;
		}
		if(dataInner[end] == 3 && (end > max || end == -1)){
			System.out.println("end :"+end);
			max = end;
			//return;
		}
		if(start != end){
		queryCountOfSameNum(dataInner, start, mid);
		queryCountOfSameNum(dataInner, mid+1, end);
		}
	}
	/**
	 * 二分类  查找算法
	 * @param data
	 * @param start
	 * @param end
	 * @param val
	 * @return
	 */
	public static int twoPartQuery(int[] data ,int start, int end ,int val){
		if(start > end || start <0 || end <0)return -1;
		int mid = start + (end -start)/2;
		System.out.println(start+" "+end);
		if(data[mid] ==  val)return mid;
		if(data[mid] > val){
			return  twoPartQuery(data, start, mid-1, val);
		}else {
			return twoPartQuery(data, mid+1, end, val);
		}
		
		
	}
	/**
	 * 查找第一个出现的 相同数字位置
	 * @param data
	 * @param start
	 * @param end
	 * @param val
	 * @return
	 */
	
	public static int findFirstTheSameNum(int[] data ,int start, int end ,int val){
		
		if(start > end || start < 0 || end < 0)return -1;
		int mid = (start+end)/2;
		
		if(data[mid] == val) {
			if(mid -1 >= 0 && data[mid-1]!= val){
				return mid;
			}else {
				return findFirstTheSameNum(data, start, mid-1, val);
			}
		}else if(data[mid] > val){
			return findFirstTheSameNum(data, start, mid-1, val);
		}else {
			return findFirstTheSameNum(data, mid+1, end, val);
		}
		
		
		
		
	}
	public static void main(String[] args) {
//		queryCountOfSameNum(ChapterSixThree.data, 0, ChapterSixThree.data.length-1);
//		System.out.println(min);
//		System.out.println(max);
//		int va = twoPartQuery(ChapterSixThree.data, 0, ChapterSixThree.data.length-1, 8);
//		System.out.println(va);
		int r=findFirstTheSameNum(ChapterSixThree.data, 0, ChapterSixThree.data.length-1,3);
		System.out.println(r);
	}
}
