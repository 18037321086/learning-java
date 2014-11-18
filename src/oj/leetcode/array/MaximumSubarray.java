package oj.leetcode.array;

/*
 * Find the contiguous subarray within an array (containing at least one 
 * number) which has the largest sum.
 * 
 * For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
 * the contiguous subarray [4,-1,2,1] has the largest sum = 6.
 * click to show more practice.
 * 
 * More practice:
 * If you have figured out the O(n) solution, try coding another solution 
 * using the divide and conquer approach, which is more subtle.
 * 
 * 
 */
public class MaximumSubarray {
	/*
	 * 1. most native way , calculate all the sums of the contiguous sub-array
	 * O(n^2) time and space
	 * and also can record the location of the subarray
	 * but cannot AC : Time Limit Exceeded
	 */
	public static int maxSubArray1(int[] A) {
		if(A == null || A.length == 0)
			return Integer.MIN_VALUE;  // invalid
		
		int len = A.length;
		int sums[][] = new int[len][len];
		for(int i = 0; i < len; i++)
			for(int j = 0; j <len ; j++)
				sums[i][j] = 0;
		
		for(int i=0; i < len; i++){
			int sum = 0;
			for(int j = i; j < len; j++){
				sum += A[j];
				sums[i][j] = sum;
			}
		}
		
		// find the max
		int max = sums[0][0];
		for(int i = 0; i < len; i++)
			for(int j = 0; j <len ; j++)
				if(sums[i][j] > max)
					max = sums[i][j];
		
 		return max;
	}
	
	/*
	 * 2. ˼ά���� ��֪��ͨ
	 * ��ǰ���󻬶� �������ǰһ�����ֺ��ܹ�ʹ������ �͸��� ������Ӹ�λ�������ۼ�
	 * ��̬�滮  --   O(n)
	 * ��μ�¼��λ����Ϣ����
	 */
	public static int maxSubArray2(int[] A) {
		if(A == null || A.length == 0)
			return Integer.MIN_VALUE;  // invalid
		
		int len = A.length;
		int preSum = A[0];
		int max = A[0];
		for(int i = 1; i < len; i++){
			preSum = Math.max(A[i], preSum + A[i]);  // update the sub
			max = Math.max(max, preSum);
		}
 		return max;
	}
	
	/*
	 * ���÷��η� ���ӳ�����Զ��׼�
	 * ���������б�Ҫ�� ���� 2.c ����Ľⷨ����������˼· ���Ӷ� O(n),����֮�������� logn
	 * Using Divide and Conquer approach, we can find the 
	 * maximum subarray sum in O(nLogn) time. 
	 * 1) Divide the given array in two halves
	 * 2) Return the maximum of following three
	 *  a) Maximum sub array sum in left half 
	 *  b) Maximum sub array sum in right half 
	 *  c) Maximum sub array sum such that the subarray crosses the midpoint
	 */
	public static int maxSubArray(int[] A) {
		if(A == null || A.length == 0)
			return Integer.MIN_VALUE;  // invalid
		
		return maxSub(A, 0, A.length-1);
	}
	
	private static int maxSub(int[] A, int from, int to) {
		
		if(from == to)
			return A[from];
		int mid = (from + to)/2;
		int maxLeft = maxSub(A, from, mid);
		int maxRight = maxSub(A, mid + 1, to);
		
		// the sub array cross the midpoint
		int leftTemp=0, maxMidToLeft = Integer.MIN_VALUE;
		int rightTemp=0, maxMidToRight = Integer.MIN_VALUE;
		for(int i=mid; i>=from; i--){
			leftTemp += A[i];
			if(leftTemp > maxMidToLeft)
				maxMidToLeft = leftTemp;
		}
		for(int i=mid+1; i<=to; i++){
			rightTemp += A[i];
			if(rightTemp > maxMidToRight)
				maxMidToRight = rightTemp;
		}
		
		return Math.max(Math.max(maxRight, maxLeft), (maxMidToLeft+maxMidToRight));
	}

	public static void main(String[] args) {
		int A[] = {-2,1,-3,4,-1,2,1,-5,4};
		System.out.println(maxSubArray1(A));
		System.out.println(maxSubArray(A));
	}
}





















