package org.leetcode.problems;

/**
 * EASY
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000226_InvertBinaryTree {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public TreeNode invertTree(TreeNode root) {
		return invert(root);

	}

	static TreeNode invert(TreeNode node) {
		if (node == null)
			return node;
		final TreeNode temp = node.left;
		node.left = invert(node.right);
		node.right = invert(temp);
		return node;
	}

}
