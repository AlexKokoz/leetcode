package org.leetcode.problems;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 
 * EASY
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000897_IncreasingOrderST {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public TreeNode increasingBST(TreeNode root) {
		Queue<Integer> inorder = new LinkedList<>();
		inorder(root, inorder);
		TreeNode newRoot = new TreeNode(inorder.poll());
		TreeNode parent = newRoot;
		while (!inorder.isEmpty()) {
			parent.right = new TreeNode(inorder.poll());
			parent = parent.right;
		}
		return newRoot;
	}

	void inorder(TreeNode node, Queue<Integer> inorder) {
		if (node == null)
			return;
		inorder(node.left, inorder);
		inorder.add(node.val);
		inorder(node.right, inorder);
	}
}
