package org.leetcode.problems;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001245_BinaryTreeColoringGame {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
		int[] size = new int[n + 1];
		size[root.val] = size(root, size);
		TreeNode target = find(root, x);
		return size[x] <= size[root.val] / 2 || (target.left != null && size[target.left.val] > size[root.val] / 2)
				|| (target.right != null && size[target.right.val] > size[root.val] / 2);
	}

	int size(TreeNode node, int[] size) {
		if (node == null)
			return 0;
		size[node.val] = 1 + size(node.left, size) + size(node.right, size);
		return size[node.val];
	}

	TreeNode find(TreeNode node, int val) {
		if (node == null)
			return null;
		if (node.val == val)
			return node;
		TreeNode left = find(node.left, val);
		TreeNode right = find(node.right, val);
		if (left != null)
			return left;
		if (right != null)
			return right;
		return null;
	}
}
