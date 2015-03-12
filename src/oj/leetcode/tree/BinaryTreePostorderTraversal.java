package oj.leetcode.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
 * Given a binary tree, return the postorder traversal of its nodes' values.
 * For example:
Given binary tree {1,#,2,3},
   1
    \
     2
    /
   3
return [3,2,1].
 * Note: Recursive solution is trivial, could you do it iteratively?
 * 
 * ���죺ǰ�к�����ķǵݹ�ʵ�ַ���
 */
public class BinaryTreePostorderTraversal {
	
	// �������ѵ�
	public List<Integer> postorderTraversal2(BinaryTreeNode root) {
		List<Integer> res = new ArrayList<Integer>();
		if(root == null) return res;
		
		Stack<BinaryTreeNode> stack = new Stack<BinaryTreeNode>();
		stack.push(root);
		BinaryTreeNode pre=null, cur=null;  // two pointer
		
		while(!stack.isEmpty() ){
			cur = stack.peek();   // for probe
			
			// continue down to the tree
			if(pre == null || pre.left == cur || pre.right == cur){
				if(cur.left != null){
					stack.push(cur.left);
				}else if(cur.right != null){
					stack.push(cur.right);
				}else{//leaf node
					res.add(cur.val);
					stack.pop();  // added before
				}
			}else if(cur.left == pre){//roll back from left child
				if(cur.right != null)
					stack.push(cur.right);
				else{
					BinaryTreeNode x = stack.pop();
					res.add(x.val);
				}
			}else if(cur.right == pre){//roll back from right child
				BinaryTreeNode x = stack.pop();
				res.add(x.val);
			}
		
			pre = cur;
		}
		
		return res;
	}
	
	// Use two stacks 
	public List<Integer> postorderTraversal3(BinaryTreeNode root) {
		List<Integer> res = new ArrayList<Integer>();
		if(root == null) return res;
		
		Stack<BinaryTreeNode> stack1 = new Stack<BinaryTreeNode>();
		Stack<BinaryTreeNode> stack2 = new Stack<BinaryTreeNode>();
		stack1.push(root);
		BinaryTreeNode pre=null, cur=null;  // two pointer
		
		while(!stack1.isEmpty() ){
			BinaryTreeNode t = stack1.pop();
			stack2.push(t);
			if(t.left != null)
				stack1.push(t.left);
			if(t.right != null)
				stack1.push(t.right);
		}
		while(!stack2.isEmpty())
			res.add(stack2.pop().val);
		
		return res;
	}
	
	//recursive is trivial
	public List<Integer> postorderTraversal(BinaryTreeNode root) {
		List<Integer> ll = new ArrayList<Integer>();
		List<Integer> rl = new ArrayList<Integer>();
		//List<Integer> rootl = new ArrayList<Integer>();
		if(root == null)	return ll;//ע�����ﲻ�Ƿ���null�����򲻷���Ҫ��
										//������Ϊ{} ��ʱ����� []
		//rootl.add(root.val);
		
		if(root.left != null) 
			ll = postorderTraversal(root.left);
		if(root.right != null) 
			rl = postorderTraversal(root.right);
		
		for(int i = 0; i<rl.size();i++)
			ll.add(rl.get(i));
		// reflect here
		ll.add(root.val);
		
		return ll;
	}
}
