package org.leetcode.problems;

/**
 * 
 * HARD
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000124_BinaryTreeMaximumPathSum {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	int max;
	public int maxPathSum(TreeNode root) {
		max = Integer.MIN_VALUE;
		maxSum(root);
		return max;
	}

	int maxSum(TreeNode node) {
		if (node == null)
			return 0;
		if (node.left == node.right) {
			max = Math.max(max, node.val);
			return node.val;
		}
		int leftMaxVal = maxSum(node.left);
		int rightMaxVal = maxSum(node.right);
		int plusLeft = node.val + leftMaxVal;
		int plusRight = node.val + rightMaxVal;
		int plusBoth = node.val + leftMaxVal + rightMaxVal;

		int maxBranch = Math.max(node.val, Math.max(plusLeft, plusRight));
		max = Math.max(max, Math.max(maxBranch, plusBoth));
		return maxBranch;
	}
}
