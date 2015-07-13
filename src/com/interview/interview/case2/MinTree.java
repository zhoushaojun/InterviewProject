package com.interview.interview.case2;

import java.util.ArrayList;
/**
 * 最小生成树
 * @author zhoushaojun
 *
 */
public class MinTree {

	private int[][] data = {
							{-1,6,1,5,-1,-1},
							{6,-1,5,-1,3,-1},
							{1,5,-1,7,5,4},
							{5,-1,7,-1,-1,2},
							{-1,3,5,-1,-1,6},
							{-1,-1,4,2,6,-1}
	                       };
	private int[][] dataTemp = null;
	private ArrayList<Integer> result = new ArrayList<Integer>(20);
	private int[] path = null;
	
	private ArrayList<Pair> kusPath = new ArrayList<Pair>();
	//prim algorithms
    public void primAlgorithms(){
    	
    	int size = data[0].length;
    	path = new int[size];
    	result.add(0);
    	//record the current Index (use for path)
    	int curIndex = -1;
    	curIndex = 0;
    	int minIndex = 0;
    	while(result.size() != size){
    		
    		minIndex = getMinIndex(size);
    		//[2] add the minIndex into result
    		result.add(minIndex);
    	}
    	for (Integer element : result) {
			System.out.println(element);
		}
    	for(int value=0;value<path.length; value++){
    		System.out.println("path "+" "+path[value]+" "+value );
    	}
    	
    }
    //[1]prim find the min Index (use result && data)
    public int getMinIndex(int size){
    	 int minIndex = -1;
    	 int minValue = Integer.MAX_VALUE;
    	 //record the curent start Index of path
    	 int curIndex = -1;
 		 for(Integer i : result){
 			for(int j = 0; j < size; j++){
 				if(data[i][j] != -1 && !result.contains(Integer.valueOf(j))){
 					
 					if(data[i][j] < minValue){
 						minValue = data[i][j];
 						minIndex = j;
 						curIndex = i;
 					}
 				}
 			}//for end
 		}//for end
 		//Then startIndex is curIndex && endIndex is minIndex(curIndex----->minIndex)
 		 path[minIndex] = curIndex;
       	 return minIndex;
    	
    }

    //kurusral algorithms
    public void kurusralAlgorithms(){
    	int size = data[0].length;
    	int loopsize = 0;
    	//initial the data node
    	ArrayList<node> nodeList = new ArrayList<node>();
    	for(int i=0; i< data.length;i++)nodeList.add(new node(i));
    	dataTemp= data;
    	node first = null,end = null;
    	int nodeSize = nodeList.size();
    	//check if start,end of pair in the same node(must break)
    	boolean inSameNode = false;
    	while(loopsize != size){
    		//[1]find the min-value pair of dataTemp
    		Pair pair = this.kurusralFindMinIndex();
    		//[2]Integrate the two node ,and add the value of end to start node ,the same time delete the end node.
    		for(int i =0;i<nodeSize;i++){
    			node nodeInner = nodeList.get(i);
    			inSameNode = false;
    			if(!nodeInner.getDeleteStatus()){
    				
		    			if(nodeInner.containsValue(pair.start) && nodeInner.containsValue(pair.end)){
		    				inSameNode = true;
		    				break;
		    			}
		    			else if(nodeInner.containsValue(pair.start)) first = nodeInner;
		    			else if(nodeInner.containsValue(pair.end)) end = nodeInner;
    		    }//if end
    		}//for end

    		if(inSameNode) continue;
    		//add the start end to path
    		kusPath.add(pair);    		
    		first.addArrayList(end);
    		end.setDelete();
    		loopsize = first.getSize();
    		
    	}//while end
    	//print result
    	for (Pair pair : kusPath) {
			System.out.println("path "+pair.start + " "+pair.end);
		}
    	System.out.println("end");
    }
    
    //Kursral find the min-value of the pair in dataTemp
    public Pair kurusralFindMinIndex(){
    	int size = dataTemp.length;
    	int minValue = Integer.MAX_VALUE;
    	int start = -1,end = -1;
    	for(int i=0; i< size;i++){
    		for(int j =i;j<size;j++){
    			if(dataTemp[i][j] != -1 && dataTemp[i][j] < minValue){
    				minValue = dataTemp[i][j];
    				start = i;end = j;
    		}
    	 }//for end
        }//for end
    	if(start != -1 && end != -1)
    	dataTemp[start][end] = -1;
    	return new Pair(start, end);
    }
   
    
    public static void main(String[] args) {
		MinTree tree = new MinTree();
		
		tree.primAlgorithms();
		tree.kurusralAlgorithms();
	}
}
//kurusral node
class node{
	public ArrayList<Integer> data = new ArrayList<Integer>();
	private boolean isDeleted = false;
	public node(int index) {
		data.add(index);
	}
	public void setDelete(){
		this.isDeleted = true;
	}
	public boolean getDeleteStatus(){
		return isDeleted;
	}
	public int getSize(){
		return this.data.size();
	}
	public boolean containsValue(int value){
		return data.contains(Integer.valueOf(value));
	}
	public void addArrayList(node outerNode){

		for (Integer value : outerNode.data) {
			this.data.add(value);
		}
	}
}
class Pair {
	public int start = -1,end = -1;
	public Pair(int start,int end){
		this.start = start;
		this.end  = end;
	}
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getEnd() {
		return end;
	}
	public void setEnd(int end) {
		this.end = end;
	}
	
	
}