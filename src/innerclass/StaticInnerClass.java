package innerclass;


class StaticInner{
	private static int a=4;
	public static class Inner{//��̬�ڲ����൱�ھ�̬��Ա����
		public void function(){
			System.out.println(a);//ֻ�ܷ���enclosing class�ľ�̬��Ա
		}
	}
}

public class StaticInnerClass {
	public static void main(String[] args) {
		//���ɾ�̬�ڲ���Ķ���
		StaticInner.Inner inner=new StaticInner.Inner();
		inner.function();
	}

}
