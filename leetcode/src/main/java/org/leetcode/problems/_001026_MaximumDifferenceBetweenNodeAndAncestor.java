package org.leetcode.problems;

import java.util.LinkedList;
import java.util.List;

public class _001026_MaximumDifferenceBetweenNodeAndAncestor {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	int max;

	public int maxAncestorDiff(TreeNode root) {
		max = Integer.MIN_VALUE;
		dfs(root);
		return max;
	}

	List<Integer> dfs(TreeNode node) {
		if (node == null)
			return new LinkedList<>();
		List<Integer> list = new LinkedList<>();
		list.addAll(dfs(node.left));
		list.addAll(dfs(node.right));
		for (int successor : list) 
			max = Math.max(max, Math.abs(node.val - successor));
		list.add(node.val);
		return list;
	}
}
