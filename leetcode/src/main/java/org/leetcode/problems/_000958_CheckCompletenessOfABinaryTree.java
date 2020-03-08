package org.leetcode.problems;

/**
 * 
 * EASY
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000958_CheckCompletenessOfABinaryTree {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	int lastDepth, maxDepth;

	public boolean isCompleteTree(TreeNode root) {
		maxDepth = 0;
		TreeNode cur = root;
		while (cur != null) {
			maxDepth++;
			cur = cur.left;
		}
		lastDepth = maxDepth;
		return dfs(root, 1);
	}

	boolean dfs(TreeNode node, int d) {
		if (node == null)
			return true;
		boolean left = dfs(node.left, d + 1);
		if (node.left == null || node.right == null) {
			if (d > maxDepth || d < maxDepth - 1)
				return false;
			if (lastDepth < d) {
				return false;
			} else {
				lastDepth = d;
			}
		}
		boolean right = dfs(node.right, d + 1);
		return left && right;
	}
}
