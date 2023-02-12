package org.leetcode.contests.weekly.w0292;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class B {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	int ans;

	public int averageOfSubtree(TreeNode root) {

		dfs(root);
		return ans;
	}

	int[] dfs(TreeNode node) {
		if (node == null)
			return new int[] { 0, 0 };
		int[] left = dfs(node.left);
		int[] right = dfs(node.right);
		int[] ret = { left[0] + right[0] + node.val, left[1] + right[1] + 1 };
		if (node.val == ret[0] / ret[1]) {
			ans++;
		}
		return ret;
	}
}
