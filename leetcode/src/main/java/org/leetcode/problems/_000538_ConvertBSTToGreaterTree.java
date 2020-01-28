package org.leetcode.problems;

import java.util.LinkedList;
import java.util.List;

/**
 * 
 * EASY
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000538_ConvertBSTToGreaterTree {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public TreeNode convertBST(TreeNode root) {
		List<TreeNode> nodes = new LinkedList<>();
		inorder(root, nodes);
		for (int i = nodes.size() - 2; i >= 0; i--)
			nodes.get(i).val += nodes.get(i + 1).val;
		return root;

	}

	void inorder(TreeNode node, List<TreeNode> nodes) {
		if (node == null)
			return;
		inorder(node.left, nodes);
		nodes.add(node);
		inorder(node.right, nodes);
	}
}
