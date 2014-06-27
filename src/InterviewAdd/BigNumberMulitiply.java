package InterviewAdd;

public class BigNumberMulitiply {
	
	private int bigNumber = 5;
	
	public void simulateBigNumberMulitiply(){
		
		int[] data = new int[10];
		data[0] = 1;
		int forward = 0;
		int digital = 1;
		//[1]The whole control for multiply of bignumber
		for(int i=2; i<=bigNumber; i++){
			
			//[2]simulate the multiply process 
			forward = 0;
			int temp = 0;
			for(int j = 1; j<=digital; j++){
				
				temp = data[j-1]*i + forward;
				data[j-1] = temp %10;
				forward = temp /10;
			}
			while(forward != 0){
				data[digital++] = forward;
				forward /=10;
			}
			
		}//for end
		
		String  str = "";
		for (int i : data) {
			str += i+"  ";
		}
		System.out.println(str);
		
	}
      public static void main(String[] args) {
		BigNumberMulitiply big = new BigNumberMulitiply();
		big.simulateBigNumberMulitiply();
	}
}
