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
	}
}
