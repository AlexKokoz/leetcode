package org.leetcode.problems;

import java.util.LinkedList;
import java.util.List;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000655_PrintBinaryTree {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public List<List<String>> printTree(TreeNode root) {
		final String EMPTY = "";
		int nRows = depth(root);
		int nCols = 1 << nRows - 1;
		List<List<String>> ans = new LinkedList<>();
		for (int r = 0; r < nRows; r++) {
			List<String> row = new LinkedList<>();
			for (int c = 0; c < nCols; c++)
				row.add(EMPTY);
			ans.add(row);
		}
		print(root, 0, nCols - 1, 0, nRows, ans);
		return ans;
	}

	int depth(TreeNode node) {
		if (node == null)
			return 0;
		return 1 + depth(node.left) + depth(node.right);
	}

	void print(TreeNode node, int l, int r, int curRow, int nRows, List<List<String>> list) {
		if (node == null)
			return;
		int mid = (r + l) / 2;
		list.get(curRow).set(mid, Integer.toString(node.val));
		print(node.left, l, mid - 1, curRow + 1, nRows, list);
		print(node.right, mid + 1, r, curRow + 1, nRows, list);
	}
}
