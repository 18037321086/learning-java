package oj.leetcode;


/*
 * You are climbing a stair case. It takes n steps to reach to the top.
 * Each time you can either climb 1 or 2 steps.
 *  In how many distinct ways can you climb to the top?
 *  
 *  Fibnacci���еĿ���
 */
public class ClimbingStairs {
	
	// �ݹ�ķ����ٶȺ�����Time Limit Exceeded
	public int climbStairs(int n) {
		if(n == 0 || n == 1)
			return 1;
		else return climbStairs(n-1) + climbStairs(n-2);
	}
	
	// ���õ����ķ�ʽ������������ظ�����
	public int climbStairs2(int n) {
		int pre = 0;
		int cur = 1; //
		for(int i = 1; i <= n; i++){
			int tmp = cur;
			cur += pre;
			pre = tmp;
		}
		
		return cur;
	}
	
	
	public static void main(String[] args) {
		System.out.println(new ClimbingStairs().climbStairs2(44));
	}
}













