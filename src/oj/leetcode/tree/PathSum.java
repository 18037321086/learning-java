package oj.leetcode.tree;

/*
 * Given a binary tree and a sum, determine if the tree has a root-to-leaf
 *  path such that adding up all the values along the path equals the given sum.

 For example:
 Given the below binary tree and sum = 22,
 5
 / \
 4   8
 /   / \
 11  13  4
 /  \      \
 7    2      1
 return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
 */
public class PathSum {
	
	// 1. ��һ��Ӧ���Ǳ���һ�飬�õ�����sum�������һ����ϣ����
	// ȴû�б�ͨ �ֶ���֮ ѯ���ӽڵ��Ƿ��� sum -x �Ľڵ� 
	// ע��������������Ҷ�ڵ� ���� value = sum
	public boolean hasPathSum(BinaryTreeNode root, int sum) {
		if(root == null)
			return false;
		boolean res = false;
		if(root.val == sum && root.left == null && root.right == null) 
			return true;
		if(root.left != null)
			res = hasPathSum(root.left, sum - root.val);
		if(root.right != null)
			res = res || hasPathSum(root.right, sum - root.val);
		
		return res;
	}
}



