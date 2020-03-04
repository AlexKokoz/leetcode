package org.leetcode.problems;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000865_SmallestSubtreeWithAllTheDeepestNodes {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	int maxDepth;
	TreeNode ans;

	public TreeNode subtreeWithAllDeepest(TreeNode root) {
		maxDepth = -1;
		dfs(root, 0);
		dfs2(root, 0);
		return ans;
	}

	void dfs(TreeNode node, int d) {
		if (node == null)
			return;
		if (maxDepth < d)
			maxDepth = d;
		dfs(node.left, d + 1);
		dfs(node.right, d + 1);
	}

	boolean dfs2(TreeNode node, int d) {
		if (node == null)
			return false;

		if (d == maxDepth) {
			ans = node;
			return true;
		}
		boolean left = dfs2(node.left, d + 1);
		boolean right = dfs2(node.right, d + 1);
		if (left && right) {
			ans = node;
			return true;
		} else if (left || right)
			return true;
		else
			return false;
	}

}
