package io;

public class RecursionTest {
	//ʹ�õݹ����׳�
	public int f(int num){
		if(1==num){//	�ݹ�ĳ��� 
			return 1;
			}
		return num*f(num-1);
	}
	
	//ʹ�õݹ����쳲���������
	public int fab(int num){
		if(num==1||2==num){
			return 1;
		}
		return fab(num-1)+fab(num-2);
	}
	
	public static void main(String[] args) {
		System.out.println(new RecursionTest().f(5));
		
		System.out.println(new RecursionTest().fab(9));
	}

}
