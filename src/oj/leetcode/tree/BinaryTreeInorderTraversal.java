package oj.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

/*
 * Given a binary tree, return the inorder traversal of its nodes' values.

 For example:
 Given binary tree {1,#,2,3},
 1
 \
 2
 /
 3
 return [1,3,2].

 Note: Recursive solution is trivial, could you do it iteratively?

 * 1. ���õݹ�ܼ�
 * 2.ͨ������ľ��ǰѵݹ�תΪ�ǵݹ� ,��������ջ
 * 
 * �����Ŀ �� Binary Tree Preorder Traversal
 */
public class BinaryTreeInorderTraversal {
	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> ll = new ArrayList<Integer>();
		List<Integer> rl = new ArrayList<Integer>();
		//List<Integer> rootl = new ArrayList<Integer>();
		if(root == null)	return ll;//ע�����ﲻ�Ƿ���null�����򲻷���Ҫ��
										//������Ϊ{} ��ʱ����� []
		//rootl.add(root.val);
		
		if(root.left != null) 
			ll = inorderTraversal(root.left);
		if(root.right != null) 
			rl = inorderTraversal(root.right);
		ll.add(root.val);
		
		
		for(int i = 0; i<rl.size();i++)
			ll.add(rl.get(i));
		
		return ll;
	}
}
