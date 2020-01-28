package org.leetcode.problems;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000102_BinaryTreeLevelOrderTraversal {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public List<List<Integer>> levelOrder(TreeNode root) {
		final List<List<Integer>> ans = new LinkedList<>();
		if (root == null)
			return ans;
		final Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		while (!q.isEmpty()) {
			final List<Integer> level = new LinkedList<>();
			for (int i = 0, len = q.size(); i < len; i++) {
				final TreeNode cur = q.poll();
				level.add(cur.val);
				if (cur.left != null)
					q.add(cur.left);
				if (cur.right != null)
					q.add(cur.right);
			}
			ans.add(level);
		}
		return ans;
	}

}
