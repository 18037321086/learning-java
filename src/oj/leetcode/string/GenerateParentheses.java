package oj.leetcode.string;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
 * Given n pairs of parentheses, write a function to generate all combinations 
 * of well-formed parentheses.
 * For example, given n = 3, a solution set is:
 * "((()))", "(()())", "(())()", "()(())", "()()()"
 * 
 * 
 */
public class GenerateParentheses {

	/*
	 * 1. ֱ���뷨����3���ַ���ͬ����վ��վ˳�򣬿�����01���� a.���нM�ϵõ����еĿ��ܽM�ϣ���ο��ٵõ� �������� b ���˵�������������
	 */
	public List<String> generateParenthesis(int n) {
		if (n <= 0)
			return null;
		int bits = 2 * n;
		// ���е�������Ͼ��� 0 - (2^bits -1)
		long sum = (1 << bits) - 1; // - ����λ�������ȼ���

		List<Long> candidate = new ArrayList<Long>();
		// System.out.println(bits);
		for (long i = 0; i <= sum; i++) {
			Stack<Long> stack = new Stack<Long>();
			if (isGood(stack, i, bits)) {
				//System.out.println("good : " + i);
				candidate.add(i);
			}
		}
		// System.out.println(candidate.size());
		int size = candidate.size();
		List<String> res = new ArrayList<String>();
		for (int i = 0; i < size; i++) {
			long one = candidate.get(i);
			res.add(getParenthesisFromLong(one, bits));
		}
		return res;
	}

	private String getParenthesisFromLong(long one, int M) {
		long MASK = 0x00000001;
		String s = "";
		for (int i = 0; i < M; i++) {
			long x = one & MASK;
			one >>= 1;
			if (x == 1)
				s = "(" + s;  // ��01һһ��Ӧ��()����  ������ǰ��
			else
				s = ")" + s;
		}
		return s;
	}

	private boolean isGood(Stack<Long> stack, long one, int M) {
		long MASK = 0x00000001;
		for (int i = 0; i < M; i++) {
			long x = one & MASK;
			one >>= 1;
			if (!stack.isEmpty()) {
				if (stack.peek() == 0 && x == 1) // ֻ�������ſ�ͷ
					stack.pop();
				else
					stack.push(x);
			} else
				stack.push(x);
		}
		if (stack.isEmpty())
			return true;
		else
			return false;
	}
	
	/*
	 * 2. ������ʾ��ôʹ�� ���� �� backtracking 
	 */

	public static void main(String[] args) {
		GenerateParentheses a = new GenerateParentheses();
		System.out.println(a.generateParenthesis(3));
		System.out.println("=======================");
		Stack<Long> stack = new Stack<Long>();
		System.out.println(a.isGood(stack, 5, 4));
		System.out.println(a.getParenthesisFromLong(42, 6));
	}
}
