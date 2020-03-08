package org.leetcode.contests.biweekly.bw0021;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001372_LongestZigZagPathBinaryTree {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	int max = 0;

	public int longestZigZag(TreeNode root) {
		dfs(root);
		return max;
	}

	int[] dfs(TreeNode node) {
		if (node == null)
			return new int[2];
		int[] left = dfs(node.left);
		max = Math.max(max, left[1]);
		int[] right = dfs(node.right);
		max = Math.max(max, right[0]);
		int[] ret = new int[2];
		ret[0] = left[1] + 1;
		ret[1] = right[0] + 1;
		return ret;
	}
}
