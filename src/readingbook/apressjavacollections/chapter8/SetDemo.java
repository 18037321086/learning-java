package readingbook.apressjavacollections.chapter8;

import java.util.HashSet;
import java.util.Set;

public class SetDemo {
	public static void main(String[] args) {
		Set s = new HashSet();
		// ��Ϊ�⼸����hashcode��һ��������ֻ�е�һ������ɹ�
		//ʣ�µķ���FALSE���ײ㷢�����滻������
		System.out.println(s.add("Hello"));
		System.out.println(s.add("Hello"));
		System.out.println(s.add(new String("Hello")));
	}

}
