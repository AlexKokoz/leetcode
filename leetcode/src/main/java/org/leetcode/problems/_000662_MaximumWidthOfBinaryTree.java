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
public class _000662_MaximumWidthOfBinaryTree {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public int widthOfBinaryTree(TreeNode root) {
		List<List<Integer>> list = new LinkedList<>();
		traverse(root, 1, 1, list);
		int max = Integer.MIN_VALUE;
		for (List<Integer> level : list) {
			if (level.size() == 1)
				max = Math.max(max, 1);
			else {
				int left = level.get(0);
				int right = level.get(level.size() - 1);
				max = Math.max(max, right - left + 1);
			}
		}
		return max;
	}

	void traverse(TreeNode node, int curLevel, int index, List<List<Integer>> list) {
		if (node == null)
			return;
		if (curLevel > list.size()) {
			List<Integer> row = new LinkedList<>();
			row.add(index);
			list.add(row);
		} else {
			list.get(curLevel - 1).add(index);
		}
		traverse(node.left, curLevel + 1, 2 * index, list);
		traverse(node.right, curLevel + 1, 2 * index + 1, list);
	}
}
