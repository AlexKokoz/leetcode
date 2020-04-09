package org.leetcode.problems;

/**
 * EASY
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000572_SubtreeOfAnotherTree {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public boolean isSubtree(TreeNode s, TreeNode t) {
		return traverse(s, t);
	}

	static boolean traverse(TreeNode root, TreeNode sub) {
		if (root == null)
			return false;
		return compare(root, sub) || traverse(root.left, sub) || traverse(root.right, sub);
	}

	static boolean compare(TreeNode root, TreeNode sub) {
		if (root == null && sub == null)
			return true;
		if ((root == null && sub != null) || (root != null && sub == null))
			return false;
		return root.val == sub.val && compare(root.left, sub.left) && compare(root.right, sub.right);
	}
}
