package innerclass;

class Fruit{
	private int a=3;
	public class Apple{//��Ա�ڲ����൱�ڷǳ�Ա��Ա����
		private int a=5;
		public void test(){
			System.out.println(Fruit.this.a);//���ⲿ���Ա�����ķ���
		}
		public void function(){
			Apple apple=new Apple();//��enclosing class�������ڲ������ķ�ʽ
			//Apple apple=this.new Apple();
		}
	}
}


public class MemberInnerClass {
	public static void main(String[] args) {
		Fruit.Apple apple=new Fruit().new Apple();
		apple.test();
	}

}
