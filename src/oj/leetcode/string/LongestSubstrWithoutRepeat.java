package oj.leetcode.string;

import java.util.HashMap;
import java.util.HashSet;

/*
 * Longest Substring Without Repeating Characters 
 * Given a string, find the length of the longest substring without repeating characters. 
 * For example, the longest substring without repeating letters for "abcabcbb" is "abc", 
 * which the length is 3. For "bbbbb" the longest substring is "b", with the length of 1.
 */
public class LongestSubstrWithoutRepeat {
	
	/*
	 * 1.Brute 
	 * ��Ϊ�������ĳ��ȣ����Բ���Ҫ����̫��Ŀռ�
	 */
	public int lengthOfLongestSubstring(String s) {
		if(s == null )
			return 0;
		if(s.length() <= 1)
			return s.length();
		
		int R = 256;
		
		int M = 0;  // current length
		int N = s.length();
		for(int i=0; i<N; i++){
			boolean[] exist = new boolean[R];
			int len = 0;
			for(int j=i; j < N; j++){
				if(exist[s.charAt(j)])
					break;
				len++;
				exist[s.charAt(j)] = true;
			}
			if(len > M)
				M = len;
		}
		return M;
	}
	
	/*
	 * 2. 
	 * ????????????????????????????????
	 * Time Limit Exceed!
	 */
	public int lengthOfLongestSubstring2(String s) {
		if(s == null )
			return 0;
		if(s.length() <= 1)
			return s.length();
		
		int M = 0;  // current length
		int N = s.length();
		for(int i=0; i<N; i++){
			HashSet hash = new HashSet();
			int len = 0;
			for(int j=i; j < N; j++){
				if(hash.contains(s.charAt(j)))
					break;
				len++;
				hash.add(s.charAt(j));
			}
			if(len > M)
				M = len;
		}
		return M;
	}
	
	/*
	 * 3. ����HashMap
	 * XXX ת�ص�
	 */
	public int lengthOfLongestSubstring3(String s) {
		if(s == null )
			return 0;
		if(s.length() <= 1)
			return s.length();
		
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		int max = 0;
		for(int i=0, j=0; i<s.length(); ++i){
			if(map.containsKey(s.charAt(i))){
				j = Math.max(j, map.get(s.charAt(i)) + 1);
			}
			map.put(s.charAt(i), i);
			max = Math.max(max, i-j+1);
		}
		
		
		return max;
	}
	
	public static void main(String[] args) {
		String s = "abcabcaabb";
		System.out.println(new LongestSubstrWithoutRepeat().lengthOfLongestSubstring3(s));
	}
}



















