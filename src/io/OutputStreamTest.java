package io;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;

public class OutputStreamTest {
	public static void main(String[] args) throws Exception {
//		OutputStream os=new FileOutputStream("f:/hello.txt");//false
		OutputStream os=new FileOutputStream("f:/hello.txt",true);//��Դ�ļ���׷����Ϣ
		String s="hello";
		byte[] buffer=s.getBytes();
		os.write(buffer);
		os.close();
	}

}
