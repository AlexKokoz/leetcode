package org.leetcode.problems;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000337_HouseRobberIII {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public int rob(TreeNode root) {
		// First element is max sum of ignoring current node.
		// Second element is max of using the current mode and not using it; that helps
		// propagate cases where the gap should be 2.
		int[] ignoredUsed = dp(root);
		return Math.max(ignoredUsed[0], ignoredUsed[1]);
	}

	int[] dp(TreeNode node) {
		int[] ignoredUsed = new int[2];
		if (node == null)
			return ignoredUsed;
		if (node.left == node.right) {
			ignoredUsed[1] = node.val;
		}
		int[] left = dp(node.left);
		int[] right = dp(node.right);
		ignoredUsed[0] = left[1] + right[1];
		ignoredUsed[1] = Math.max(node.val + left[0] + right[0], ignoredUsed[0]);
		return ignoredUsed;
	}
}
