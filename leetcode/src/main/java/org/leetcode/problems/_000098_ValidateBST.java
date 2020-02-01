package org.leetcode.problems;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000098_ValidateBST {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public boolean isValidBST(TreeNode root) {
		return validate(root, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);
	}

	boolean validate(TreeNode node, double min, double max) {
		if (node == null)
			return true;
		if (min >= node.val || node.val >= max)
			return false;
		return validate(node.left, min, node.val) && validate(node.right, node.val, max);
	}
}
