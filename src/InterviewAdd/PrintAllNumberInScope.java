package InterviewAdd;

public class PrintAllNumberInScope {
	
	public void printTheWholeNumber(){
		
		//initial some parameters
		int length = 10;
		int[] data = new int[length];
		int overflow = 0;
		
		int sum =0;
		
		boolean stopWhile = true;
		while(stopWhile){
		for(int i = length -1;i>=0;i--){
			sum = data[i]  + overflow;
			if(i == length - 1) sum++;
			
			if(sum >= 10){
				if(i ==8) stopWhile = false;
				sum -=10;
				data[i] = sum ;
				overflow = 1;
				
			}else{
				data[i] =sum ;
				overflow = 0;
				printf(data);
				break;
			}
			
		}
	  }
	}
    public void printTheWholeNumberCharArray(){
		
		//initial some parameters
		int length = 10;
		//char array must initial
		char[] data = new char[length];
		for(int i =0;i<data.length;i++)data[i] = '0';
		int overflow = 0;
		
		int sum =0;
		
		boolean stopWhile = true;
		while(stopWhile){
		for(int i = length -1;i>=0;i--){
			sum = data[i] - '0'  + overflow;
			if(i == length - 1) sum++;
			
			if(sum >= 10){
				if(i ==8) stopWhile = false;
				sum -=10;
				data[i] = (char)(sum + '0');
				overflow = 1;
			}else{
				data[i] =(char)(sum + '0');
				overflow = 0;
				printfChar(data);
				break;
			}
		}
	  }
	}
	
	public void printf(int []data){
		
		String string = "";
		for (int i = 0; i <data.length; i++) {
			string += data[i]+" ";
		}
		
		System.out.println(string);
	}
	
	public void printfChar(char []data){
		String string = "";
		for(int i =0;i<data.length;i++){
			int c = (data[i] -'0');
			string += c+" ";
			
		}
		System.out.println(string);
		
	}
	public static void main(String[] args) {
		PrintAllNumberInScope print = new PrintAllNumberInScope();
		//print.printTheWholeNumber();
		print.printTheWholeNumberCharArray();


	
	}
}
