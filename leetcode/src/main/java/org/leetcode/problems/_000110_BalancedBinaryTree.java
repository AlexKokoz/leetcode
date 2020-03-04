package org.leetcode.problems;

/**
 * 
 * EASY
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000110_BalancedBinaryTree {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public boolean isBalanced(TreeNode root) {
		if (root == null || root.left == root.right)
			return true;
		if (Math.abs(height(root.left, 0) - height(root.right, 0)) > 1)
			return false;

		return isBalanced(root.left) && isBalanced(root.right);
	}

	int height(TreeNode node, int height) {
		if (node == null)
			return height;
		return Math.max(height(node.left, height + 1), height(node.right, height + 1));
	}

}
