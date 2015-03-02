package oj.leetcode.string;

/*
 * Write a function to find the longest common prefix 
 * string amongst an array of strings.
 * ʱ�临�Ӷ��� O(nm) vs ʹ�� Trie ��
 */
public class LongestCommonPrefix {
	
	/*
	 * native way to scan
	 */
	public static String longestCommonPrefix(String[] strs) {
		if(strs == null || strs.length == 0)
			return "";
		// ������Ҫ�������� strs = {};
		if(strs.length == 1)
			return strs[0];
		
		// to look up the min len
		int min = Integer.MAX_VALUE;
		for(String s : strs)
			if(s.length() < min)
				min = s.length();
		if(min == 0)
			return "";
		//�ٴ�ǿ��breakֻ���ж�һ��ѭ��
		int i=0;
		loop:
		for(i=0; i < min; i++){
			char c = strs[0].charAt(i);
			for(int j=1; j < strs.length; j++)
				if(strs[j].charAt(i) != c)
					break loop;
		}
		
		return strs[0].substring(0,i);

	}
	public static void main(String[] args) {
		String ss[] = {};
		System.out.println(longestCommonPrefix(ss));
	}
}
