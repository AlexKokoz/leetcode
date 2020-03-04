package org.leetcode.problems;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000173_BinarySearchTreeIterator {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	class BSTIterator {
		TreeNode root;
		TreeNode cur;

		public BSTIterator(TreeNode root) {
			this.root = root;
			while (root != null && root.left != null)
				root = root.left;
			cur = root;
		}

		/** @return the next smallest number */
		public int next() {
			TreeNode temp = null;
			final int val = cur.val;
			cur = root;
			while (cur != null) {
				if (cur.val > val)
					temp = cur;
				if (cur.val > val)
					cur = cur.left;
				else if (cur.val <= val)
					cur = cur.right;
			}
			if (cur == null)
				cur = temp;
			return val;
		}

		/** @return whether we have a next smallest number */
		public boolean hasNext() {
			return cur != null;
		}
	}
}
