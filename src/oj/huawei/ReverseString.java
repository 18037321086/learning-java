package oj.huawei;

import java.util.Scanner;

/*
 * ��һ���ַ���str�����ݵߵ��������������str�ĳ��Ȳ�����100���ַ��� �磺���롰I am a student���������tneduts a ma I����
���������
inputString��������ַ���

����ֵ��
���ת���õ������ַ���
 */
public class ReverseString {
	
	public static String reverseString(String s){
		return new StringBuilder(s).reverse().toString();
	}
	
	public static void main(String args){
		Scanner scan = new Scanner(System.in);
		String in = scan.nextLine();
		System.out.println(reverseString(in));
	}

}
