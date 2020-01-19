package org.leetcode.contests.weekly.w0172;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001325_DeleteLeavesWithAGivenValue {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public TreeNode removeLeafNodes(TreeNode root, int target) {
		delete(null, root, target);
		if (root != null && root.left == root.right && root.val == target)
			return null;
			
		return root;
	}

	void delete(TreeNode p, TreeNode ch, int t) {
		if (ch == null)
			return;
		delete(ch, ch.left, t);
		delete(ch, ch.right, t);
		if (ch.left == ch.right && ch.val == t && p != null)
			if (p.left == ch)
				p.left = null;
			else
				p.right = null;
	}

}
