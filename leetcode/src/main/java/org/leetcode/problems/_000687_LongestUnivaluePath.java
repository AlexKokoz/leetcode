package org.leetcode.problems;

/**
 * 
 * EASY
 * 
 * @author akokozidis
 *
 */
public class _000687_LongestUnivaluePath {

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
	
	int max;
	public int longestUnivaluePath(TreeNode root) {
		max = 0;
		dfs(root);
		return max == 0 ? 0 : max - 1;
	}
	
	int dfs(TreeNode node) {
		if (node == null) return 0;
		if (node.left == node.right) return 1;
		int left = dfs(node.left);
		if (node.left == null || node.left.val != node.val)
			left = 0;
		int right = dfs(node.right);
		if (node.right == null || node.right.val != node.val)
			right = 0;
		int both = 1 + left + right;
		max = Math.max(max, both);
		return 1 + Math.max(left, right);		
	}
}
