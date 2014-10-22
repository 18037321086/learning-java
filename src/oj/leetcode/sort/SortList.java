package oj.leetcode.sort;


/*
 * Sort a linked list in O(n log n) time using constant space complexity.
 * 
 * ʱ�临�Ӷ�Ϊ nlogn �������㷨���ǹ鲢 �� ���ţ��������ʺ�ǰ�ߣ�˫�����ʺϿ���
 * �鲢����ܼ򵥣��ؼ���ÿ�ζ԰�ָ�������
 */
public class SortList {
	public ListNode sortList(ListNode head) {
		if(head == null || head.next == null)
			return head;
		ListNode slow = head, fast = head;
		while(fast.next != null && fast.next.next != null){
			slow = slow.next;
			fast = fast.next.next;
		}
		fast = slow;
		slow = slow.next;
		fast.next = null;  // �Ͽ�
		
		ListNode left = sortList(head);
		ListNode right = sortList(slow);
		return mergeTwoLists(left, right);
	}

	//�����ѭ�����Ʊ� MergeTwoSortedLists.java �и��Ӽ��
	public ListNode mergeTwoLists(ListNode p, ListNode q) {
		ListNode dummy = new ListNode(-1);
		dummy.next = null;
		ListNode cur = dummy;
		while(p != null || q != null){
			int v1 = p==null ? Integer.MAX_VALUE:p.val;
			int v2 = q==null ? Integer.MAX_VALUE:q.val;
			ListNode tmp;
			if(v1 < v2){
				tmp = p.next;
				p.next = cur.next;
				cur.next = p;
				p = tmp;
			}else{
				tmp = q.next;
				q.next = cur.next;
				cur.next = q;
				q = tmp;
			}
			cur = cur.next;
		}
		
		return dummy.next;
	}	
	
}
