package generic;

import java.util.LinkedList;
import java.util.List;
//���Ʋ���T�̳�ĳ�����ʵ��ĳ���ӿڣ�Ҫ�ùؼ���extends
//��û�в�����Tʱ��Ĭ��T extends Object
public class ListGenericFoo<T extends List<String>> {
	private T foo;

	public T getFoo() {
		return foo;
	}

	public void setFoo(T foo) {
		this.foo = foo;
	}
	
	public static void main(String[] args) {
		ListGenericFoo<LinkedList<String>> foo1=new ListGenericFoo<LinkedList<String>>();
		LinkedList<String> list=new LinkedList<String>();
		foo1.setFoo(list);
	}

}
