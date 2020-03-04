package org.leetcode.problems;

/**
 * 
 * EASY
 * 
 * @author akokozidis
 *
 */
public class _000671_SecondMinimumNodeInABinaryTree {

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public int findSecondMinimumValue(TreeNode root) {
		int secondMin = find(root, root.val);
		return secondMin == root.val ? -1 : secondMin;
	}

	int find(TreeNode node, int min) {
		if (node.left == node.right)
			return node.val;
		int left = find(node.left, min);
		int right = find(node.right, min);
		if (left == min)
			return right;
		if (right == min)
			return left;
		return Math.min(left, right);
	}
}
