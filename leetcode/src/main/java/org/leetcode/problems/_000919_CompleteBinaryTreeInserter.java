package org.leetcode.problems;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000919_CompleteBinaryTreeInserter {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	class CBTInserter {
		private final Deque<TreeNode> leaves; // from left to right
		private final TreeNode root;

		public CBTInserter(TreeNode root) {
			this.root = root;
			leaves = new ArrayDeque<>();
			getLeaves(root);
		}

		public int insert(int v) {
			TreeNode parent = leaves.getFirst();
			int parVal = parent.val;
			TreeNode newNode = new TreeNode(v);
			if (parent.left == null) {
				parent.left = newNode;
			} else {
				parent.right = newNode;
				leaves.removeFirst();
			}
			leaves.addLast(newNode);
			return parVal;
		}

		public TreeNode get_root() {
			return root;
		}

		// ================================================================================
		// HELPER METHODS
		// ================================================================================
		void getLeaves(TreeNode node) {
			if (node == null)
				return;
			Queue<TreeNode> q = new LinkedList<>();
			q.add(node);
			while (!q.isEmpty()) {
				TreeNode cur = q.poll();
				if (cur.left == null || cur.right == null)
					leaves.addLast(cur);
				if (cur.left != null)
					q.add(cur.left);
				if (cur.right != null)
					q.add(cur.right);
			}
		}
	}
}
