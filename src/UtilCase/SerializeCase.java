package UtilCase;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import javax.lang.model.element.NestingKind;

public class SerializeCase implements Serializable{
	
	public int data = 10;
	protected String str = "zhoushaojun";
	private String leng = "leng";

	public static void main(String[] args) {
		
		try {
			SerializeCase secase = new SerializeCase();
			FileOutputStream fout = new FileOutputStream("zhou.txt");
			ObjectOutputStream obj = new ObjectOutputStream(fout);
			obj.writeObject(secase);
			
			FileInputStream inputStream = new FileInputStream("zhou.txt");
			ObjectInputStream objIn = new ObjectInputStream(inputStream);
			SerializeCase newcse = (SerializeCase)objIn.readObject();
			System.out.println(newcse.data);
			System.out.println(newcse.leng);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
