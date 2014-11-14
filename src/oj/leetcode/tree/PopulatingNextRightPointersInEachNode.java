package oj.leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


/*
 * Given a binary tree

    struct TreeLinkNode {
      TreeLinkNode *left;
      TreeLinkNode *right;
      TreeLinkNode *next;
    }
Populate each next pointer to point to its next right node. 
If there is no next right node, the next pointer should be set to NULL.

Initially, all next pointers are set to NULL.

Note:
You may only use constant extra space.
You may assume that it is a perfect binary tree (ie, all leaves are at the 
same level, and every parent has two children).

For example,
Given the following perfect binary tree,
         1
       /  \
      2    3
     / \  / \
    4  5  6  7
After calling your function, the tree should look like:
         1 -> NULL
       /  \
      2 -> 3 -> NULL
     / \  / \
    4->5->6->7 -> NULL
 * �ؼ��㣺 ��ȫ������   �����ռ临�Ӷ�
 */
public class PopulatingNextRightPointersInEachNode {
	/*
	 * ��ֱ�ӵ��뵽�ò������ Ȼ��ÿһ��Ľڵ���nextָ�봮��
	 * ���ǿռ临�Ӷ���  O(����) + O(�ڵ�����)
	 */
	public void connect1(TreeLinkNode root) {
		if(root == null)
			return;
		Queue<TreeLinkNode> qu = new LinkedList<TreeLinkNode>();
		List<TreeLinkNode> res = new ArrayList<TreeLinkNode>();
		
		qu.offer(root);
		qu.offer(null);
		TreeLinkNode cur = null;
		
		while(!qu.isEmpty()){
			cur = qu.poll(); // front the queue
			res.add(cur);
			if(cur != null){
				if(cur.left != null)
					qu.offer(cur.left);
				if(cur.right != null)
					qu.offer(cur.right);
			}else{
				// �����һ��null ����֮�� Ҫ��ֹ ����ѭ��
				if(!qu.isEmpty())
					qu.offer(null);
			}
		}
		
		// concatenate by next pointer
		if(res.size() <= 2){
			root.next = null;
			return ;
		}
		int size = res.size();
		TreeLinkNode pre=root,node=null;
		for(int i = 1; i < size; i++){
			node = res.get(i);
			if(pre != null){
				pre.next = node;
				pre = node;
			}else{
				pre = node;// watch out here
				continue;
			}
		}
	} 
	
	/*
	 * �����൱�ڶԽڵ���������˵�ɨ�� ���ռ临�ӶȺܴ�
	 * ��������ع����ڲ�������Ĺ����� ����nextָ��
	 * ��ʱ�ռ临�Ӷ���  O(����)
	 */
	public void connect2(TreeLinkNode root) {
		if(root == null)
			return;
		Queue<TreeLinkNode> qu = new LinkedList<TreeLinkNode>();
		
		qu.offer(root);
		qu.offer(null);
		TreeLinkNode cur = null, pre = null;
		
		while(!qu.isEmpty()){
			cur = qu.poll(); // front the queue
			
			//every time traverse a node, update next pointer here
			if(pre != null)
				pre.next = cur;
			//����������Ҫ�ǵ��ƶ� pre ָ�� 
			pre = cur;
			
			// offer its children to the queue
			if(cur != null){
				if(cur.left != null)
					qu.offer(cur.left);
				if(cur.right != null)
					qu.offer(cur.right);
			}else{
				// �����һ��null ����֮�� Ҫ��ֹ ����ѭ��
				if(!qu.isEmpty())
					qu.offer(null);
			}
		}
	} 
	
	/*
	 * �ѵ������������ constant extra space.
	 * �ؼ��㣺����������һ���Ѿ���next�����������ʣ���������ǰ��һ�㣬����ͼ��������⡣
	 */
	public void connect(TreeLinkNode root) {
		// bcs it is perfect tree , so just test its left pointer
		if(root == null || root.left == null)
			return;
		
		TreeLinkNode parent = root, son = parent.left;
		root.next = null;
		while(son != null){
			TreeLinkNode temp = son; //next time go to next level
			
			// use son pointer to traverse this level
			while(son != null){
				son.next = parent.right;
				son = son.next;
				// to the next component
				parent = parent.next;
				son.next = (parent != null) ? parent.left : null;
				son = son.next;
			}
			
			parent = temp;
			son = parent.left;
		}
		
	} 
	
	public static void main(String[] args) {
		Queue<Integer> test= new LinkedList<Integer>();
		test.offer(1);
		test.offer(null);//  can offer null 
	}
		    

}
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
