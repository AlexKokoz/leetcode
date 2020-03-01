package org.leetcode.problems;

/**
 * 
 * EASY
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000814_BinaryTreePruning {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public TreeNode pruneTree(TreeNode root) {
		if (!containsOne(null, root)) return null;
		return root;
	}

	boolean containsOne(TreeNode par, TreeNode ch) {
		if (ch == null)
			return false;
		boolean containsOne = containsOne(ch, ch.left) || containsOne(ch, ch.right) || ch.val == 1;
		if (!containsOne )
			if (par.left == ch)
				par.left = null;
			else
				par.right = null;
		else
			return true;
		return false;
	}

}
