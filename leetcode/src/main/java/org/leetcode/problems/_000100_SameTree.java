package org.leetcode.problems;

/**
 * 
 * EASY
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000100_SameTree {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public boolean isSameTree(TreeNode p, TreeNode q) {
		return same(p, q);
	}

	boolean same(TreeNode a, TreeNode b) {
		if (a == null && b == null)
			return true;
		if (a == null || b == null)
			return false;
		if (a.val != b.val)
			return false;
		return same(a.left, b.left) && same(a.right, b.right);
	}
}
