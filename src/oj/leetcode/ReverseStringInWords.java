package oj.leetcode;

import java.util.StringTokenizer;

// no. 1
/*
 * Given an input string, reverse the string word by word.
 * For example,
 * Given s = "the sky is blue",
 * return "blue is sky the".
 * 
 * Update (2015-02-12):TODO
 * For C programmers: Try to solve it in-place in O(1) space.
 * 
 * Clarification:
 * What constitutes a word?
 * A sequence of non-space characters constitutes a word.
 * Could the input string contain leading or trailing spaces?
 * Yes. However, your reversed string should not contain leading or trailing spaces.
 * How about multiple spaces between two words?
 * Reduce them to a single space in the reversed string.
 * 
 * 
 */
public class ReverseStringInWords {
	
	/*
	 * 1. ����Java��API������ϸ�ںܶ�
	 */
	public String reverseWords(String s) {
		if (s == null || s.length() == 0)
			return "";

		// split() ������ַ�����ͷ�մ�����ĩβ��û��
		String arr[] = s.split(" ");
		if (arr.length == 0)
			return "";
		StringBuilder sb = new StringBuilder();
		for (int i = arr.length - 1; i >= 0; i--) {
			if (!arr[i].equals(""))
				sb.append(arr[i]).append(" ");
		}

		// ȥ�����һ���ո�
		String result = sb.toString();
		return result.substring(0, result.length() - 1);
	}
	
	/*
	 * 2. ��ô StringTokenizer �أ��Ͳ����п�ͷ�Ŀո�
	 * "    " ���� StringTokenizer �õ����ǿմ�"" ��Ҫ�ر�ע��
	 */
	public String reverseWords2(String s) {
		if (s == null || s.length() == 0)
			return "";

		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(s, " ");
		while(st.hasMoreElements()){
			sb.insert(0, st.nextElement()+" ");
		}
		// ȥ�����һ���ո�
		String result = sb.toString();
		//System.out.println(result);
		if(result.length() <= 0)
			return "";
		else return result.substring(0, result.length() - 1);
	}
	
	/*
	 * 3. ��C�������ʵ�� in-place in O(1) space. ������
	 */

	public static void main(String[] args) {
		String s = "   rwerqwe vwrtqw3 c  ";
		String arr[] = s.split(" ");
		for (int i = 0; i < arr.length; i++)
			System.out.println("=" + arr[i] + "=");
		String s2 = " ";
		System.out.println(new ReverseStringInWords().reverseWords2(s2) + "=");
	}
}
