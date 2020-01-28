package org.leetcode.problems;

/**
 * 
 * EASY
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000104_MaximumDepthOfBinaryTree {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public int maxDepth(TreeNode root) {
		return depth(root, 1);
	}

	int depth(TreeNode node, int depth) {
		if (node == null)
			return depth - 1;
		if (node.left == node.right)
			return depth;
		return Math.max(depth(node.left, depth + 1), depth(node.right, depth + 1));
	}
}
