package org.leetcode.problems;

/**
 * 
 * EASY
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000783_MinimumDistanceBetweenBSTNodes {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public int minDiffInBST(TreeNode root) {
		return minDiff(root);
	}

	int minDiff(TreeNode node) {
		if (node == null || node.left == node.right)
			return Integer.MAX_VALUE;
		int floor = floor(node);
		int ceil = ceil(node);
		return Math.min(Math.min(Math.abs(node.val - ceil), Math.abs(node.val - floor)),
				Math.min(minDiff(node.left), minDiff(node.right)));
	}

	int ceil(TreeNode node) {
		if (node.right == null)
			return Integer.MAX_VALUE;
		node = node.right;
		while (node.left != null)
			node = node.left;
		return node.val;
	}

	int floor(TreeNode node) {
		if (node.left == null)
			return Integer.MAX_VALUE;
		node = node.left;
		while (node.right != null)
			node = node.right;
		return node.val;
	}
}
