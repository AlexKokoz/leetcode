package org.leetcode.contests.weekly.w0209;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001609_EvenOddTree {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public boolean isEvenOddTree(TreeNode root) {
		Deque<TreeNode> dq = new ArrayDeque<>();
		dq.add(root);
		for (int i = 0; !dq.isEmpty(); i++) {
			Deque<TreeNode> ndq = new ArrayDeque<>();
			if (i % 2 == 0) {
				int prev = 0;
				for (TreeNode node : dq) {
					if ((node.val & 1) == 0 || node.val <= prev)
						return false;
					prev = node.val;
					if (node.left != null)
						ndq.add(node.left);
					if (node.right != null)
						ndq.add(node.right);
				}
			} else {
				int prev = Integer.MAX_VALUE;
				for (TreeNode node : dq) {
					if ((node.val & 1) == 1 || node.val >= prev)
						return false;
					prev = node.val;
					if (node.left != null)
						ndq.add(node.left);
					if (node.right != null)
						ndq.add(node.right);
				}
			}
			dq = ndq;
		}
		return true;
	}
}
