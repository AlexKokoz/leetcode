package org.leetcode.problems;

/**
 * 
 * EASY
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000112_PathSum {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public boolean hasPathSum(TreeNode root, int sum) {
		return hasPathSum(root, sum, 0);
	}

	boolean hasPathSum(TreeNode node, int targetSum, int currentSum) {
		if (node == null)
			return false;
		// both children null
		if (node.left == node.right) {
			if (currentSum + node.val == targetSum)
				return true;
		}
		return hasPathSum(node.left, targetSum, currentSum + node.val)
				|| hasPathSum(node.right, targetSum, currentSum + node.val);
	}

}
