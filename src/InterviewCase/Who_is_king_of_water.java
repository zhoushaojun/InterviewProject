package InterviewCase;
/**
 * 查找数组中水王，数量超过一半的数值
 * @author zhoushaojun
 *
 */
public class Who_is_king_of_water {
    private int[] data = {0,1,2,3,2,2,2,2,5,4,9,7};
    public int getCount(){
    	int tempcount = 1;
    	int tempKing  = data[0];
    	int size = data.length;
    	for(int i = 1; i < size; i++){
    		if(tempcount == 0){
    			tempcount = 1;
    			tempKing  =data[i];
    			continue;
    		}
    		if(data[i] != tempKing)tempcount--;
    		else {
				tempcount++;
			}
    	}
    	return tempKing;
    }
    public static void main(String[] args) {
		Who_is_king_of_water water = new Who_is_king_of_water();
		System.out.println(water.getCount());
	}
}
