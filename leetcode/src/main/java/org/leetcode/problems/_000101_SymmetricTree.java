package org.leetcode.problems;

/**
 * 
 * EASY
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000101_SymmetricTree {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public boolean isSymmetric(TreeNode root) {
		return root == null ? true : symmetric(root.left, root.right);
	}

	boolean symmetric(TreeNode left, TreeNode right) {
		if (left == null && right == null)
			return true;
		if (left == null ^ right == null || left.val != right.val)
			return false;
		return symmetric(left.left, right.right) && symmetric(left.right, right.left);
	}
}
