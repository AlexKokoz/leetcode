package org.leetcode.problems;

/**
 * 
 * EASY
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000404_SumOfLeftLeaves {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public int sumOfLeftLeaves(TreeNode root) {
		return sum(null, root);
	}

	int sum(TreeNode parent, TreeNode child) {
		if (child == null)
			return 0;
		if (child.left == child.right && parent != null && parent.left == child)
			return child.val;
		return sum(child, child.left) + sum(child, child.right);
	}
}
