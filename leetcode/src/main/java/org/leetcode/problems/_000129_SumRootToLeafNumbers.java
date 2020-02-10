package org.leetcode.problems;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000129_SumRootToLeafNumbers {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public int sumNumbers(TreeNode root) {
		return sum(root, 0);
	}

	int sum(TreeNode node, int num) {
		if (node == null)
			return num;
		num = num * 10 + node.val;
		if (node.left == node.right)
			return num;
		return (node.left == null ? 0 : sum(node.left, num)) + (node.right == null ? 0 : sum(node.right, num));
	}
}
