package org.leetcode.problems;


/**
 * 
 * 
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000965_UnivaluedBT {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public boolean isUnivalTree(TreeNode root) {
		return isUnivalTree(null, root);
	}

	boolean isUnivalTree(TreeNode parent, TreeNode child) {
		if (child == null)
			return true;
		if (parent != null && parent.val != child.val)
			return false;
		return isUnivalTree(child, child.left) && isUnivalTree(child, child.right);
	}
}
