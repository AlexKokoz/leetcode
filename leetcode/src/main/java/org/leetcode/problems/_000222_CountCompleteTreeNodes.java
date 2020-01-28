package org.leetcode.problems;

/**
 * 
 * EASY
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000222_CountCompleteTreeNodes {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public int countNodes(TreeNode root) {
		return count(root);
	}

	int count(TreeNode node) {
		if (node == null)
			return 0;
		return 1 + count(node.left) + count(node.right);
	}
}
