package org.leetcode.problems;

/**
 * 
 * EASY
 * 
 * @author akokozidis
 *
 */
public class _000669_TrimABST {

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public TreeNode trimBST(TreeNode root, int L, int R) {
		return trim(root, L, R);
	}

	static TreeNode trim(TreeNode root, int lo, int hi) {
		if (root == null)
			return root;
		TreeNode node = null;
		if (lo <= root.val && root.val <= hi) {
			node = new TreeNode(root.val);
		} else if (root.val < lo) {
			return trim(root.left, lo, hi);
		} else {
			return trim(root.right, lo, hi);
		}
		node.left = trim(root.right, lo, hi);
		node.right = trim(root.left, lo, hi);
		return node;
	}
}
