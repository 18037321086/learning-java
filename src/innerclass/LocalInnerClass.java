package innerclass;

class A{
	public void function1(){
		final int a=90;//
		class B{//�ֲ��ڲ��� �����ڷ������У�ֻ�ܷ���final �ĳ�Ա����
			//�ֲ��ڲ���û��public�ȵ����Σ���ͬ�ֲ�����һ��
			public void function2(){System.out.println(a);} 
		}
		new B().function2();
	}
}

public class LocalInnerClass {
	public static void main(String[] args) {
		new A().function1();
	}

}
