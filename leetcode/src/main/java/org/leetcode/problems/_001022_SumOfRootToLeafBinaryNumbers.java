package org.leetcode.problems;

/**
 * 
 * EASY
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001022_SumOfRootToLeafBinaryNumbers {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public int sumRootToLeaf(TreeNode root) {
		return sum(root, 0);
	}

	int sum(TreeNode node, int sum) {
		if (node == null)
			return 0;
		if (node.left == node.right)
			return sum * 2 + node.val;
		return sum(node.left, sum * 2 + node.val) + sum(node.right, sum * 2 + node.val);
	}
}
