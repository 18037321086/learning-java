package oj.leetcode.tree;


/*
 * Given a binary tree, find its minimum depth.
 * The minimum depth is the number of nodes along the shortest path 
 * from the root node down to the nearest leaf node.
 * ע������Ķ��壺�ǵ�Ҷ�ڵ����̾��룬����{1,3}Ӧ�����2 ������1
 * 
 * �������   -- MaxDepthBinaryTree
 */
public class MinimumDepthBinaryTree {
	public int minDepth(TreeNode root) {
		if (root == null)
			return 0; 
		return getDepth(root);
	}
	public int getDepth(TreeNode root) {
		if (root == null)
			return Integer.MAX_VALUE; // ע������
		if(root.left == null && root.right == null)
			return 1;
		
		int left = getDepth(root.left);
		int right = getDepth(root.right);

		return Math.min(left, right) + 1;
	}
}
