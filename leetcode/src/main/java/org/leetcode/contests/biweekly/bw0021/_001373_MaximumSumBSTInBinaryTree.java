package org.leetcode.contests.biweekly.bw0021;

/**
 * 
 * HARD
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001373_MaximumSumBSTInBinaryTree {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	int max = 0;

	public int maxSumBST(TreeNode root) {
		dfs(root);
		return max;
	}

	int[] dfs(TreeNode node) {
		if (node == null)
			return new int[] { Integer.MAX_VALUE, Integer.MIN_VALUE, 0 };
		int[] left = dfs(node.left);
		int[] right = dfs(node.right);
		if (node.val <= left[1] || node.val >= right[0])
			return new int[] { Integer.MIN_VALUE, Integer.MAX_VALUE, 0 };
		int[] ret = new int[] {Math.min(left[0], node.val), Math.max(right[1], node.val), node.val + left[2] + right[2]};
		max = Math.max(max, ret[2]);
		return ret;
	}
}
