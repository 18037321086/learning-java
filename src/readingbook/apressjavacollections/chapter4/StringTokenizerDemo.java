package readingbook.apressjavacollections.chapter4;

import java.util.StringTokenizer;

public class StringTokenizerDemo {
	public static void main(String[] args) {
		StringTokenizer st = new StringTokenizer("  vonzhou  , inhao .");
		while(st.hasMoreElements()){
			// ��nextElement�������ص���Object����
			System.out.println(st.nextElement());
		}
		
		System.out.println("=============================");
		st = new StringTokenizer("  vonzhou  , inhao .");
		while(st.hasMoreTokens()){
			// �������������nextToken�������ص��� String����
			System.out.println(st.nextToken());
		}
	}

}
