package RMITest;

import java.rmi.Naming;

public class clientTest {
	public static void main(String[] args) {
		try {
			
			Hello hello = (Hello)Naming.lookup("rmi://localhost:12312/hello");
			System.out.println(hello.hello());
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
