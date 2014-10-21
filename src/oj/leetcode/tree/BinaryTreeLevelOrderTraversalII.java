package oj.leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


/*
 * Given a binary tree, return the bottom-up level order traversal of its nodes' values.
 *  (ie, from left to right, level by level from leaf to root).
 *  For example:
 *  Given binary tree {3,9,20,#,#,15,7},
    3
   / \
  9  20
    /  \
   15   7
return its bottom-up level order traversal as:
[
  [15,7],
  [9,20],
  [3]
]
 */
/*
 * ����һ���ⲻͬ���ǣ�����Ҫ�Ե����ϵķ�ʽ��ֻ��Ҫ��������ķ�ʽ�ı伴��
 */
public class BinaryTreeLevelOrderTraversalII {
	  public List<List<Integer>> levelOrderBottom(TreeNode root) {
		  
		  Queue<TreeNode> queue = new LinkedList<TreeNode>();
		  // ��������ͷ�巨ʵ�ֵ���
		  List<List<Integer>> res = new LinkedList<List<Integer>>();  
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
			  res.add(0, level); // ע������
		  }
		  
		  return res;
	  }      
}








