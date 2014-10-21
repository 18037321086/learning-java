package oj.leetcode.tree;

import java.util.Arrays;
import java.util.List;

public class MaxDepthBinaryTree {
	// ��Ϊ��֪���ڵ������������ֻ��ͨ���ݹ������
	public int maxDepth(TreeNode root) {
		if (root == null)
			return 0;
		int left = maxDepth(root.left);
		int right = maxDepth(root.right);

		return Math.max(left, right) + 1;
	}

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(1, 3, 45, 67, 7, 8, 9, 10);
		BinaryTree bt = new BinaryTree(list);
		TreeNode root = bt.createBiTreeFromList();
		System.out.println(new MaxDepthBinaryTree().maxDepth(root));
	}

}
