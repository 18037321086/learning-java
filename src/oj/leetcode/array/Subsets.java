package oj.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Given a set of distinct integers, S, return all possible subsets.
 * Note:
 * Elements in a subset must be in non-descending order.
 * The solution set must not contain duplicate subsets.
 * For example,
 * If S = [1,2,3], a solution is:
 [
 [3],
 [1],
 [2],
 [1,2,3],
 [1,3],
 [2,3],
 [1,2],
 []
 ]
 * Tag: Array, Backtracking, Bit Manipulation
 * ****************************************************************
 */
public class Subsets {

	/*
	 * 1 �ѵ��������λ���� bits[N] ÿһλ��0/1�ʹ����Ӽ����и�Ԫ���Ƿ���� �� 0 ~ 2^N ���ǰ�����Nλbits������������
	 * Ȼ����Ӧλ��1ת��Ϊ��Ӧ��Ԫ�ؼ��� ʱ�临�Ӷ��Ƕ�������
	 */
	public List<List<Integer>> subsets1(int[] S) {
		if (S == null || S.length == 0)
			return null;
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		ArrayList<Integer> list = new ArrayList<Integer>();

		// �Ը����������������
		Arrays.sort(S);

		int n = S.length; // number of elements
		long len = 1 << n;//
		for (int i = 0; i < len; i++) {
			for (int j = 0; j < n; j++) {
				// ��λΪ1�Ķ�ӦԪ�ؼ��뼯��
				if ((i & 1 << j) != 0)
					list.add(S[j]);
			}
			result.add(list); // ���� i=0 �ͻ����һ���ռ���
			// Ϊ��һ���Ӽ��ϴ洢��׼��
			list = new ArrayList<Integer>();
		}

		return result;
	}

	/*
	 * 2 ����λ����ֱ���õݹ鹹������е��Ӽ��� TODO ��������
	 */

	/*
	 * 3 
	 * author:azheanda The idea is to look at each value in the input set one
	 * by one and 1)first recursive call--put it in the previously generated
	 * subsets 2)second--don't. This is recursive back tracking problem. Very
	 * important:within one recursive call, restore the global invariant in
	 * between the recursive calls.
	 *  ���⣺���������˻��ݣ� �����ڣ�������һ��Ԫ�� �����ڻ���ɾ���Ǹ�Ԫ�� ����һ���ָ������Ĺ���
	 */
	public List<List<Integer>> subsets(int[] S) {
		// Start typing your Java solution below
		// DO NOT write main() function
		Arrays.sort(S);
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		List<Integer> cset = new ArrayList<Integer>();
		subsets(S, 0, res, cset);
		return res;

	}

	public void subsets(int[] S, int off, List<List<Integer>> res,
			List<Integer> cset) {
		if (off == S.length) {
			res.add(new ArrayList<Integer>(cset)); 
			// When add one subset to the result set, we can't just
													// say "res.add(cset)"
													// because
			return; // cset is just a pointer to the ArrayList object(the
					// program would modify cset later on).
		} // So we have to invoke the copy constructor instead.
		cset.add(S[off]);
		subsets(S, off + 1, res, cset);
		cset.remove(cset.size() - 1); // Very important--restore the global
										// invariant for next recursive calls.
		subsets(S, off + 1, res, cset);
	}

	/* 4
	 *  �ǵݹ飺�ȼ���һ���ռ�������һ�ΰ���һ��Ԫ�ؼ��뵽֮ǰ���Ӽ��еõ�һ���µ��Ӽ�
	 *  �磺
	 *  1) #
	 *  2) 1, |#
	 *  3) 2, 1 2, |#, 1
	 *  4) 2 3, 1 2 3, 3, 1 3 ,| 2, 1 2, #, 1
	 */
	public List<List<Integer>> subsets3(int[] S) {
		
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<Integer> list = new ArrayList<Integer>();
		result.add(list);   // a empty set
		
		if (S == null || S.length == 0)
			return result;
		
		Arrays.sort(S);
		for(int i=0; i<S.length; i++){
			int sofar = result.size();
			System.out.println("sz:" + sofar);
			for(int j=0; j<sofar; j++){
				// List<Integer> newset = result.get(j);  // IS wrong !!! need copy constructor
				List<Integer> newset = new ArrayList<Integer>(result.get(j));
				newset.add(S[i]);
				result.add(newset);
			}
		}
		
		return result;
	}

	public static void main(String[] args) {
		Subsets s = new Subsets();
		List<List<Integer>> sub = s.subsets(new int[] { 1, 2, 3 });
		System.out.println(sub);
		sub = s.subsets3(new int[] { 1, 2, 3 });
		System.out.println(sub);
	}
}
