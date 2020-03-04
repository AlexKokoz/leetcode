package org.leetcode.problems;

/**
 * 
 * EASY
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000563_BinaryTreeTilt {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	int sum;

	public int findTilt(TreeNode root) {
		sum = 0;
		tilt(root);
		return sum;
	}

	int tilt(TreeNode node) {
		if (node == null)
			return 0;
		if (node.left == node.right)
			return node.val;
		int left = tilt(node.left);
		int right = tilt(node.right);
		sum += Math.abs(left - right);
		return left + right + node.val;
	}
}
