package SwordOffer;

import java.io.File;

public class GetFilesofTree {
	private static final String path = "1";
	public static void getFilesofTree(File file, int length){
		if(file.isDirectory()){
			File[] files = file.listFiles();
			for (File fileInner : files) {
				getFilesofTree(fileInner,length+1);
			}
		}else{
			System.out.println(length+" "+file.getAbsolutePath()+" "+file.getName());
		}
	}
	public static void main(String[] args) {
		GetFilesofTree.getFilesofTree(new File(path),1);
		Test test = new Test();
		System.out.println(test.str);
		System.out.println(test.num);
		System.out.println(test.dnum);
		double kk = 1.4;
		Double kkdDouble = null;
		System.out.println(String.valueOf(kk));
		System.out.println("d "+String.valueOf(kkdDouble).replaceAll("null", ""));
	}
}
class Test {
	public String str;
	public int num;
	public double dnum;
	public float kk = 1.3f;
	
}
 