package io;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;

public class BufferedOutputStreamTest {
	public static void main(String[] args) throws Exception {
		OutputStream os=new FileOutputStream("f:/hello.txt");
		BufferedOutputStream bos=new BufferedOutputStream(os);
		bos.write("vonzhou".getBytes());
		bos.close();//���ͷ���Դǰ���ײ�����flush��������������������д���ļ���
		os.close();
	}

}
