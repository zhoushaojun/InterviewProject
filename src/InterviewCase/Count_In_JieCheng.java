package InterviewCase;

public class Count_In_JieCheng {

	  private int num = 4;
	  
	  public int getCount(){
		  int count = 0;
		  int temp;
		  for(int i = 1; i <= num; i++){
			  temp = i;
			  while(temp % 5 == 0){
				  count ++;
				  temp /= 5;
			  }
		  }
		  return count;
	  }
	  public int getCountAnother(){
		  
		  int count = 0;
		  int temp  = num;
		  int base  = 5;
		  while(base <= temp){
			  count += temp/base;
			  base*=5;
			  
		  }
		  return count;
	  }
	  public int getCountBinary(){
		  int temp = num;
		  int count = 0;
		  int base = 2;
		  while(base <= temp){
			  count += temp / base;
			  base*=2;
			  
		  }
		  return count+1;
	  }
	  public static void main(String[] args) {
		Count_In_JieCheng jieCheng = new Count_In_JieCheng();
		System.out.println(jieCheng.getCount());
		System.out.println(jieCheng.getCountAnother());
		System.out.println(jieCheng.getCountBinary());
	}
	  
}
