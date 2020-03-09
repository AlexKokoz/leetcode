package org.leetcode.problems;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001010_DeleteNodesAndReturnForest {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	Set<Integer> toDeleteValues;
	Set<TreeNode> ans;

	public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
		toDeleteValues = new HashSet<>();
		ans = new HashSet<>();
		if (!toDeleteValues.contains(root.val))
			ans.add(root);
		for (int val : to_delete)
			toDeleteValues.add(val);
		dfs(null, root);
		return new LinkedList<>(ans);
	}

	void dfs(TreeNode p, TreeNode node) {
		if (node == null)
			return;
		int val = node.val;
		if (toDeleteValues.contains(val)) {
			if (p != null) {
				if (p.left == node)
					p.left = null;
				else
					p.right = null;
			}
			if (ans.contains(node))
				ans.remove(node);
			if (node.left != null)
				ans.add(node.left);
			if (node.right != null)
				ans.add(node.right);
		}

		dfs(node, node.left);
		dfs(node, node.right);
	}
}
