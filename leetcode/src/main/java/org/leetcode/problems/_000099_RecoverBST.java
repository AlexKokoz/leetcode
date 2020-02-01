package org.leetcode.problems;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 
 * HARD
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000099_RecoverBST {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public void recoverTree(TreeNode root) {
		List<TreeNode> nodes = new LinkedList<>();
		List<Integer> vals = new LinkedList<>();
		inorder(root, nodes, vals);
		Collections.sort(vals);
		for (int i = 0; i < vals.size(); i++)
			nodes.get(i).val = vals.get(i);
	}

	void inorder(TreeNode node, List<TreeNode> nodes, List<Integer> vals) {
		if (node == null)
			return;
		inorder(node.left, nodes, vals);
		nodes.add(node);
		vals.add(node.val);
		inorder(node.right, nodes, vals);
	}

}
