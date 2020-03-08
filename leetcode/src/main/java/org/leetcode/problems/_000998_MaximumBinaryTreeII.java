package org.leetcode.problems;

import java.util.LinkedList;
import java.util.List;

public class _000998_MaximumBinaryTreeII {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	List<Integer> list;
	public TreeNode insertIntoMaxTree(TreeNode root, int val) {
		list = new LinkedList<>();
		morrisInorder(root);
		list.add(val);
		return build(list, 0, list.size() - 1);
	}
	
	void morrisInorder(TreeNode root) {
		TreeNode cur = root;
		while(cur != null) {
			if (cur.left == null) {
				list.add(cur.val);
				cur = cur.right;
			} else {
				TreeNode predecessor = cur.left;
				while(predecessor.right != null && predecessor.right != cur)
					predecessor = predecessor.right;
				if (predecessor.right == null) {
					predecessor.right = cur;
					cur = cur.left;
				} else {
					predecessor.right = null;
					list.add(cur.val);
					cur = cur.right;
				}
			}
		}
	}
	TreeNode build(List<Integer> list, int l, int r) {
		if (l > r) return null;
		int maxPos = findMax(list, l, r);
		TreeNode root = new TreeNode(list.get(maxPos));
		root.left = build(list, l, maxPos - 1);
		root.right = build(list, maxPos + 1, r);
		return root;
	}
	
	int findMax(List<Integer> list, int l, int r) {
		int maxElem = Integer.MIN_VALUE;
		int maxPos = -1;
		for (int i = l; i <= r; i++) {
			int elem = list.get(i);
			if (elem > maxElem) {
				maxElem = elem;
				maxPos = i;
			}
		}
		return maxPos;
	}
}
