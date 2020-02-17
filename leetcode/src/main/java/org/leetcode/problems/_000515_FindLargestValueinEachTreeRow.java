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
public class _000515_FindLargestValueinEachTreeRow {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public List<Integer> largestValues(TreeNode root) {
		List<Integer> list = new LinkedList<>();
		dfs(root, list, 0);
		return list;
	}

	void dfs(TreeNode node, List<Integer> list, int level) {
		if (node == null)
			return;
		if (level < list.size())
			list.add(node.val);
		else
			list.set(level, Math.max(list.get(level), node.val));
		dfs(node.left, list, level + 1);
		dfs(node.right, list, level + 1);
	}
}
