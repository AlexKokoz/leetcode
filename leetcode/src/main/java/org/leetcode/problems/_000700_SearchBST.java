package org.leetcode.problems;

/**
 * 
 * EASY
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000700_SearchBST {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public TreeNode searchBST(TreeNode root, int val) {
		return search(root, val);
	}

	TreeNode search(TreeNode node, int val) {
		if (node == null)
			return null;
		if (val < node.val)
			return search(node.left, val);
		if (node.val < val)
			return search(node.right, val);
		return node;
	}
}
