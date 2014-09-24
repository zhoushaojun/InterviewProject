package InterviewCase2;

import java.util.ArrayList;
/**
 * ×î¶ÌÂ·¾¶
 * @author zhoushaojun
 *
 */
public class MinPathAlgorithms {

	private int[][] data = new int[][]{
			                            {-1,10,-1,30,100},
			                            {-1,-1,50,-1,-1},
			                            {-1,-1,-1,-1,10},
			                            {-1,-1,20,-1,60},
			                            {-1,-1,-1,-1,-1}
			                           };
	private int[] singlesource = null;
	private ArrayList<Integer> result = new ArrayList<Integer>(12);
	//path of the graph
	private int[] path = null;
	
	public void getData(){
		//initial the singlesource
		singlesource = data[0];
		result.add(0);
		
		//initial the path
		int SingleSourceSize = data[0].length;
		path = new int[SingleSourceSize];
		for(int i =0; i< SingleSourceSize; i++){
			if(singlesource[i] != -1) path[i] = 1;
			else path[i] = -1;
		}
		
		//the whole loop
		int minIndex = 0;
		while(result.size() != singlesource.length){
			//[1]find the index of min-value to result(expect -1 && already result index)
			minIndex = getMinvalueIndex(singlesource);
			result.add(minIndex);
			updataSingleSource(minIndex);
		}
        for (Integer element : result) {
			
        	System.out.println(element);
		}
        for (int value : singlesource) {
        	System.out.println("source "+value);
			
		}
        for (int value : path) {
			System.out.println(value);
		}
		
	}
	//[1]find the index of min-value
	public int getMinvalueIndex(int[] datain){
		int minvalue = Integer.MAX_VALUE;
		int index = -1;
		int size  = datain.length;
		for (int i=0;i<size;i++) {
			if(datain[i] != -1 && !result.contains(Integer.valueOf(i)) ){
				if(datain[i] < minvalue){
				   minvalue = datain[i];
				   index = i;
				}
			}
		}
		return index;
	}
	//[2-3]according the index update the singlesource data
	public void updataSingleSource(int index){
		
		int sourcevalue = singlesource[index];
		int size = data[index].length;
		for(int i=0; i<size;i++){
			if(data[index][i]!= -1 && !result.contains(Integer.valueOf(i))){
				if(singlesource[i] == -1) {
					singlesource[i] =  sourcevalue + data[index][i];
					path[i] = index+1;
				}
				else if(sourcevalue + data[index][i] < singlesource[i]) 
						singlesource[i] = sourcevalue + data[index][i];
				        path[i] = index+1;
				
				
			}
			
		}
		
	}
	public static void main(String[] args) {
		MinPathAlgorithms min = new MinPathAlgorithms();
		min.getData();
	}
}
