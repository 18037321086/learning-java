package io;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;

public class ByteArrayOutputStreamTest {
	public static void main(String[] args) throws Exception {
		ByteArrayOutputStream baos=new ByteArrayOutputStream();
		//String str="��ս��֮��";//һ����ռ�����ֽ�
		String str="vonzhou";
		byte[] buffer=str.getBytes();
		baos.write(buffer);//���ַ�����Ӧ���ֽ���д�� �ֽ��������
		
		byte[] result=baos.toByteArray();//���ֽڴ������ó���
		
		System.out.println(result.length);
		for(int i=0;i<result.length;i++){
			System.out.println((char)result[i]);
		}
		
		//���ֽ����е�����д�뵽�ļ��������
		OutputStream os=new FileOutputStream("hello.txt");
		baos.writeTo(os);
		baos.close();
		os.close();
		
		
		
	}

}
