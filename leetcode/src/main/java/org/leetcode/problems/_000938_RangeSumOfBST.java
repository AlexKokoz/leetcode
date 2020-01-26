package org.leetcode.problems;

/**
 * 
 * EASY
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000938_RangeSumOfBST {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public int rangeSumBST(TreeNode root, int L, int R) {
		return sum(root, L, R);
	}

	int sum(TreeNode node, int L, int R) {
		if (node == null)
			return 0;
		if (node.val > R)
			return sum(node.left, L, R);
		if (node.val < L)
			return sum(node.right, L, R);
		return node.val + sum(node.left, L, R) + sum(node.right, L, R);
	}
}
