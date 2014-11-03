package oj.leetcode;


/*
 * The count-and-say sequence is the sequence of integers beginning as follows:
 * 1, 11, 21, 1211, 111221, ...
 * 1 is read off as "one 1" or 11.
 * 11 is read off as "two 1s" or 21.
 * 21 is read off as "one 2, then one 1" or 1211.
 * Given an integer n, generate the nth sequence.
 *
 *Note: The sequence of integers will be represented as a string.
 *
 *�ܽ᣺�������ܼ򵥣�����Ҫһ����д��ȴ���ѣ��ر���ϸ�ڣ�Ҫ��˼·��������������ͼ��
 */
public class CountAndSay {
	//���ϵ���
	public String countAndSay(int n) {
		if(n <= 0)
			return "";
		else if(1 == n)
			return "1";
		int cnt = 0;
		String cur = "1";
		String tmp = "";
		for(int i = 2; i <= n; i++){
			cnt = 1;
			tmp = "";
			char pre = cur.charAt(0);
			for(int j = 1; j < cur.length(); j++){
				char ch = cur.charAt(j);
				if( ch == pre)
					cnt ++;
				else {
					// count and say ��ǰ���һ��
					tmp = tmp + cnt + pre ;
					//����
					pre = ch;
					cnt = 1;
				}
				
			}
			tmp = tmp  + cnt+ pre;
			cur = tmp;
			//System.out.println(cur);
		}
		return cur;
	}
	
	public static void main(String[] args) {
		CountAndSay cas = new CountAndSay();
		System.out.println(cas.countAndSay(5));
	}
}











