package oj.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class BinaryTreePreorderTraversal {
	
	//�ݹ�ʵ��
	public static List<Integer> preorderTraversal(TreeNode root) { 
		List<Integer> ll = new ArrayList<Integer>();
		List<Integer> rl = new ArrayList<Integer>();
		List<Integer> rootl = new ArrayList<Integer>();
		if(root == null)	return rootl;//ע�����ﲻ�Ƿ���null�����򲻷���Ҫ��
										//������Ϊ{} ��ʱ����� []
		rootl.add(root.val);
		
		if(root.left != null) 
			ll = preorderTraversal(root.left);
		if(root.right != null) 
			rl = preorderTraversal(root.right);
		for(int i = 0; i<ll.size();i++)
			rootl.add(ll.get(i));
		for(int i = 0; i<rl.size();i++)
			rootl.add(rl.get(i));
		
		return rootl;
	}
	
	// ����һ��ջ��ʵ��
	public static List<Integer> preorderTraversal2(TreeNode root) { 
		Stack<TreeNode> stack = new Stack<TreeNode>();
		List<Integer> rootl = new ArrayList<Integer>();
		if(root == null) return rootl;
		stack.push(root);
		
		while(!stack.isEmpty()){
			TreeNode node = stack.pop();
			rootl.add(node.val);
			if(node.left != null)
				stack.push(node.left);
			if(node.right != null)
				stack.push(node.right);
		}
		
		return rootl;
	}
	
	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree(Arrays.asList(12,45));
		TreeNode root = bt.createBiTreeFromList();
		
		List<Integer> res = preorderTraversal(root);
		System.out.println(res);
	}

}
