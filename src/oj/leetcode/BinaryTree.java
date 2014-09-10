package oj.leetcode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTree {
	List<Integer> list;
	TreeNode root;
	int size;

	public BinaryTree(List<Integer> list) {
		this.list = list;
		this.size = list.size();
	}

	public TreeNode createBiTreeFromList() {
		int parentIndex = 0;
		// ����Щ����ת��Ϊһ�����ڵ�
		List<TreeNode> nodes = new ArrayList<TreeNode>();
		for (int i = 0; i < list.size(); i++)
			nodes.add(new TreeNode(list.get(i)));

		int lastParentIndex = nodes.size() / 2 - 1;
		// ���ݶ��������ص㽫��Щ�ڵ���������
		for (parentIndex = 0; parentIndex < lastParentIndex; parentIndex++) {
			nodes.get(parentIndex).left = nodes.get(2 * parentIndex + 1);
			nodes.get(parentIndex).right = nodes.get(2 * parentIndex + 2);
		}

		// ֻ��Ҫ�����һ�����ڵ�������⿼��
		nodes.get(lastParentIndex).left = nodes.get(2 * lastParentIndex + 1);
		if (nodes.size() % 2 == 1)
			nodes.get(lastParentIndex).right = nodes
					.get(2 * lastParentIndex + 2);

		return nodes.get(0);
	}

}
