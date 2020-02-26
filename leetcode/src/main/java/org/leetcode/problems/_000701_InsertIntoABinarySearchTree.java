package org.leetcode.problems;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000701_InsertIntoABinarySearchTree {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public TreeNode insertIntoBST(TreeNode root, int val) {
		return insert(root, val);
	}
	
	TreeNode insert(TreeNode node, int val ) {
		if (node == null)
			return new TreeNode(val);
		if (val < node.val) 
			node.left = insert(node.left, val);
		else if (node.val < val)
			node.right = insert(node.right, val);
		return node;
	}
}
