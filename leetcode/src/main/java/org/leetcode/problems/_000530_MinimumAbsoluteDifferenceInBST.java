package org.leetcode.problems;

/**
 * 
 * EASY
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000530_MinimumAbsoluteDifferenceInBST {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public int getMinimumDifference(TreeNode root) {
		return minDiff(root);
	}

	int minDiff(TreeNode node) {
		if (node == null)
			return Integer.MAX_VALUE;
		int ceil = ceil(node);
		int floor = floor(node);
		return Math.min(Math.min(Math.abs(node.val - floor), Math.abs(ceil - node.val)),
				Math.min(minDiff(node.left), minDiff(node.right)));
	}

	int floor(TreeNode node) {
		if (node.left == null)
			return Integer.MAX_VALUE;
		node = node.left;
		while (node.right != null)
			node = node.right;
		return node.val;
	}

	int ceil(TreeNode node) {
		if (node.right == null)
			return Integer.MAX_VALUE;
		node = node.right;
		while (node.left != null)
			node = node.left;
		return node.val;
	}
}
