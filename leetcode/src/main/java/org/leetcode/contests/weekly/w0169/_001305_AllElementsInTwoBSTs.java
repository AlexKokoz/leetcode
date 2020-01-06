package org.leetcode.contests.weekly.w0169;

import java.util.LinkedList;
import java.util.List;


/**
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001305_AllElementsInTwoBSTs {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
		final List<Integer> ans = new LinkedList<>();
		final List<Integer> list1 = new LinkedList<>();
		final List<Integer> list2 = new LinkedList<>();
		inorder(root1, list1);
		inorder(root2, list2);
		merge(list1, list2, ans);
		return ans;
	}

	static void inorder(TreeNode node, List<Integer> list) {
		if (node == null)
			return;

		inorder(node.left, list);
		list.add(node.val);
		inorder(node.right, list);
	}

	static void merge(List<Integer> l1, List<Integer> l2, List<Integer> ans) {
		final int n1 = l1.size();
		final int n2 = l2.size();
		int i = 0;
		int j = 0;
		while (i < n1 || j < n2) {
			if (i == n1)
				while (j < n2)
					ans.add(l2.get(j++));
			else if (j == n2)
				while (i < n1)
					ans.add(l1.get(i++));
			else if (l1.get(i) <= l2.get(j))
				ans.add(l1.get(i++));
			else
				ans.add(l2.get(j++));
		}
	}

}
