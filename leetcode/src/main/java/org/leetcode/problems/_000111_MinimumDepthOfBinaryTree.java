package org.leetcode.problems;

/**
 * 
 * EASY
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000111_MinimumDepthOfBinaryTree {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public int minDepth(TreeNode root) {
		if (root == null)
			return 0;
		if (root.left == root.right)
			return 1;
		int leftDepth = root.left != null ? minDepth(root.left) + 1 : Integer.MAX_VALUE;
		int rightDepth = root.right != null ? minDepth(root.right) + 1 : Integer.MAX_VALUE;
		return Math.min(leftDepth, rightDepth);
	}

}
