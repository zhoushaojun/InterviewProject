package InterviewCase2;

public class MaxCommonSequence {

    private char[] first  = {'a','b','c','d','e','f','x','y'};
	private char[] second = {'h','i','j','d','e','f','z'};
	public void getmaxcommon(){
       int sizefirst  = first.length;
       int sizesecond = second.length;
       int max = 0;
       int everycount = 0;
       int starti = 0;
       int start = 0;
       int end  =0;
       for(int i = 0; i<sizefirst; i++){
    	   everycount = 0;
    	   starti = i;
    	   for(int j = 0; j< sizesecond;j++){
    		   
    		   if(first[i] == second[j]){
    			   everycount++;
    			   i++;
    			 
    		   }
    		   if(everycount > max){
    			   max = everycount;
    			   start = starti;
    			   end = i;
    		   }
    	   }
       }//for end
       
       System.out.println(start+" "+end);
	}

	public void getmaxcommon2(){
		int sizefirst  = first.length;
	    int sizesecond = second.length;
	    int [][]data = new int[sizefirst][sizesecond];
	    //记录当前 最大长度以及最大的INDEX
	    int maxlength = 0;
	    int end = -1;
	    for(int i=0; i<sizefirst;i++){
	    	if(i < sizesecond && first[i] == second[i] ){
	    		//according the left cornor index value
	    		if(i-1 > 0 ){
	    			data[i][i] = data[i-1][i-1]+1;
	    		}else{
	    			data[i][i] = 1;
	    		}
	    		//record the max index
	    		if(data[i][i] > maxlength){
	    			maxlength = data[i][i];
	    			end = i;
	    		}
	    	}
	    }
       // printf the result
	    System.out.println("max index "+end);
	    for (int[] is : data) {
	    	String string = "";
			for (int i : is) {
				string += i +" ";
			}
			System.out.println(string);
		}
		
		
	}
	public static void main(String[] args) {
		MaxCommonSequence commonSequence = new MaxCommonSequence();
		commonSequence.getmaxcommon2();
	}
}
