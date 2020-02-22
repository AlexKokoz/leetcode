package org.leetcode.problems;

/**
 * 
 * EASY
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000543_DiameterOfBinaryTree {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public int diameterOfBinaryTree(TreeNode root) {
		if (root == null)
			return 0;
		int[] ans = new int[1];
		diameter(root, ans);
		return ans[0] - 1;
	}

	int diameter(TreeNode node, int[] ans) {
		if (node == null)
			return 0;
		if (node.right == node.left) {
			ans[0] = Math.max(ans[0], 1);
			return 1;
		}
		int left = diameter(node.left, ans);
		int right = diameter(node.right, ans);
		ans[0] = Math.max(ans[0], 1 + left + right);
		return Math.max(left, right) + 1;
	}
}
