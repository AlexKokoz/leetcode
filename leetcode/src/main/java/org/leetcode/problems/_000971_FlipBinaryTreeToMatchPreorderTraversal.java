package org.leetcode.problems;

/**
 * 
 * 
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000971_FlipBinaryTreeToMatchPreorderTraversal {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	int moves;

	public int distributeCoins(TreeNode root) {
		moves = 0;
		dfs(root);
		return moves;
	}

	int dfs(TreeNode node) {
		if (node == null)
			return 0;
		int left = dfs(node.left);
		int right = dfs(node.right);
		moves += Math.abs(left) + Math.abs(right);
		return node.val + left + right - 1; // -1 accounts for the current node
	}

}
