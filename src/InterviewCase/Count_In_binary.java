package InterviewCase;

public class Count_In_binary {

	 private int num = 22;
	 public int getCountFirst(){
		 
		 int count = 0;
		 int temp  = num;
		 while(0 != temp){
			 count += temp&0x01;
			 temp>>=1;
		 }
		 return count;
	 }
	 
	 public int getCountTwo(){
		 
		 int count = 0;
		 int temp  = num;
		 while(0 != temp){
			 temp&=(temp-1);
			 count++;
		 }
		 return count;
	 }
	 
	 public static void main(String[] args) {
		Count_In_binary count = new Count_In_binary();
		System.out.println(count.getCountFirst());
		System.out.println(count.getCountTwo());
	}
}
