package innerclass;

import java.util.Date;
/**
 * �����ڲ�����Ҫ������  Implicitly extends a class or implements a interface
 * @author vonzhou
 *
 */
public class AnonymousInnerClass {
	
	@SuppressWarnings("deprecation")
	public void get(Date date){
		System.out.println(date.toLocaleString());
	}
	
	public static void main(String[] args) {
		new AnonymousInnerClass().get(new Date(){
		//������һ���̳���Date��������ڲ���Ķ���
	    //������д����ķ���
			public String toLocaleString(){
				return "��ǰϵͳʱ���ǣ�"+super.toLocaleString();
			}
		});
	}

}
