package org.leetcode.problems;

/**
 * 30-day Leetcoding Challenge
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000000_CheckIfAStringIsAValidSequenceFromRootToLEavesPathInABinaryTree {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public boolean isValidSequence(TreeNode root, int[] arr) {
		return dfs(root, arr, 0);
	}

	boolean dfs(TreeNode node, int[] arr, int d) {
		if (node == null || d == arr.length || arr[d] != node.val)
			return false;
		if (node.left == node.right && d == arr.length - 1 && node.val == arr[d])
			return true;
		if (dfs(node.left, arr, d + 1))
			return true;
		return dfs(node.right, arr, d + 1);
	}
}
