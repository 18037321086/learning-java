package io;

import java.io.File;

public class FileTest2 {
	public static void main(String[] args) {
		File file=new File("f:/abc/xyz/hello");
		System.out.println(file.mkdir());//ֻ�ܴ���һ��Ŀ¼
		
		System.out.println(file.mkdirs());
		System.out.println(file.isDirectory());
	}

}
