package readingbook.apressjavacollections.chapter7;

import java.util.ArrayList;
import java.util.Arrays;

public class IteratorRemove2 {
	public static void main(String[] args) {
		String ss[] = {"1st", "2nd", "3rd", "4th", "5th",
                "1st", "2nd", "3rd", "4th", "5th"};
		ArrayList<String> al = new ArrayList<String>(Arrays.asList(ss));
		
		for(String s: al){// ������Ȼʹ�õĵ�������
			// java.util.ConcurrentModificationException �쳣
			if(s.equals("3rd"))
				al.remove(s);
		}
		System.out.println(al);
	}

}
