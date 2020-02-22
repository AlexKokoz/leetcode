package org.leetcode.problems;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000450_DeleteNodeInABST {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public TreeNode deleteNode(TreeNode root, int key) {
		return delete(root, key);

	}

	TreeNode rotateRight(TreeNode node) {
		if (node == null)
			return null;
		if (node.left == null)
			return node;
		TreeNode newRoot = node.left;
		node.left = newRoot.right;
		newRoot.right = node;
		return newRoot;
	}

	TreeNode rotateLeft(TreeNode node) {
		if (node == null)
			return null;
		if (node.right == null)
			return node;
		TreeNode newRoot = node.right;
		node.right = newRoot.left;
		newRoot.left = node;
		return newRoot;
	}

	TreeNode delete(TreeNode node, int key) {
		if (node == null)
			return null;
		if (key < node.val)
			node.left = delete(node.left, key);
		else if (node.val < key)
			node.right = delete(node.right, key);
		else if (node.right != null) {
			TreeNode cur = node.right;
			while (cur.left != null)
				cur = rotateRight(cur);
			cur.left = node.left;
			return cur;
		} else if (node.left != null) {
			TreeNode cur = node.left;
			while (cur.right != null)
				cur = rotateLeft(cur);
			cur.right = node.right;
			return cur;
		} else
			return null;
		return node;
	}
}
