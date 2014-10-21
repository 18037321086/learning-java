package oj.leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


/*
 * Given a binary tree, return the level order traversal of its 
 * nodes' values. (ie, from left to right, level by level).
 * For example:
 * Given binary tree {3,9,20,#,#,15,7},
    3
   / \
  9  20
    /  \
   15   7
  return its level order traversal as:
[
  [3],
  [9,20],
  [15,7]
]

 */
/*
 * ����������ö���
 * ÿһ��Ľ�����ξ��������Ƕ�ÿ����μ���(������ͨ����ǰ���еĳ��Ⱦ���)
 */
public class BinaryTreeLevelOrderTraversal {
	  public List<List<Integer>> levelOrder(TreeNode root) {
		  Queue<TreeNode> queue = new LinkedList<TreeNode>();
		  List<List<Integer>> res = new ArrayList<List<Integer>>();
		  List<Integer> level ; // deal with every level
		  
		  if(root == null)
			  return res;  // Ҫ��յ�ʱ�򷵻� "[]"������null
		  
		  queue.offer(root);
		  while(!queue.isEmpty()){
			  level = new ArrayList<Integer>();
			  // ÿһ���ʱ����һ�δ�С���������ڴ���Ĺ����У�����for(int i = 0; i < queue.size(); i++)
			  int size = queue.size();
			  for(int i = 0; i < size; i++){
				  TreeNode cur = queue.remove();
				  //Retrieves and removes the head of this queue.
				  //This method differs from poll only in that it throws an 
				  //exception if this queue is empty.

				  if(cur.left != null)
					  queue.add(cur.left);
				  if(cur.right != null)
					  queue.add(cur.right);
				  level.add(cur.val);
			  }
			  
			  res.add(level); // get one level iterated
		  }
		  
		  return res;
	  }      
}








