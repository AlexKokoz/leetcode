package org.leetcode.problems;

/**
 * 
 * EASY
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000235_LowestCommonAncestorOfABinarySearchTree {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	TreeNode ancestor;

	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		ancestor = null;
		commonAncestor(root, p, q);
		return ancestor;
	}

	boolean commonAncestor(TreeNode node, TreeNode p, TreeNode q) {
		if (node == null)
			return false;
		if (ancestor != null)
			return true;
		boolean left = commonAncestor(node.left, p, q);
		boolean right = commonAncestor(node.right, p, q);
		if (left && right || ((left || right) && (node == p || node == q))) {
			ancestor = node;
			return true;
		}
		if (node == p || node == q)
			return true;
		return left || right;
	}

}
