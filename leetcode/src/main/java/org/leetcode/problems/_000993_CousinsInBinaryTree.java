package org.leetcode.problems;

/**
 * 
 * EASY
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000993_CousinsInBinaryTree {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public boolean isCousins(TreeNode root, int x, int y) {
		return !haveTheSameParent(root, x, y) && depth(root, x, 0) == depth(root, y, 0);
	}

	boolean haveTheSameParent(TreeNode node, int a, int b) {
		if (node == null)
			return false;
		if (node.left == null || node.right == null)
			return haveTheSameParent(node.left, a, b) || haveTheSameParent(node.right, a, b);
		if ((node.left.val == a || node.left.val == b) && (node.right.val == a || node.right.val == b))
			return true;
		return haveTheSameParent(node.left, a, b) || haveTheSameParent(node.right, a, b);
	}

	int depth(TreeNode node, int val, int depth) {
		if (node == null)
			return Integer.MIN_VALUE;
		if (node.val == val)
			return depth;
		return Math.max(depth(node.left, val, depth + 1), depth(node.right, val, depth + 1));
	}

}
