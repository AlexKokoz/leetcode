package org.leetcode.problems;

import java.util.*;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001161MaximumLevelSumOfABinaryTree {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	// ========================================================================
	// Solution 1: Recursive DFS
	// ========================================================================
	public int maxLevelSum(TreeNode root) {
		List<Integer> sums = new LinkedList<>();
		dfs(root, sums, 1);
		int bestSum = Integer.MIN_VALUE;
		int bestLevel = 0;
		for (int i = 0; i < sums.size(); i++) {
			if (sums.get(i) > bestSum) {
				bestSum = sums.get(i);
				bestLevel = i + 1;
			}
		}
		return bestLevel;
	}

	void dfs(TreeNode node, List<Integer> sums, int level) {
		if (node == null)
			return;
		if (level > sums.size())
			sums.add(node.val);
		else
			sums.set(level - 1, sums.get(level - 1) + node.val);
		dfs(node.left, sums, level + 1);
		dfs(node.right, sums, level + 1);
	}

	// ========================================================================
	// Solution 2: Iterative	 BFS
	// ========================================================================
//	public int maxLevelSum(TreeNode root) {
//		Queue<TreeNode> q = new LinkedList<>();
//		int level = 1;
//		int bestLevel = 0;
//		int bestSum = Integer.MIN_VALUE;
//
//		q.add(root);
//		while (!q.isEmpty()) {
//			int sum = 0;
//			for (int i = 0, len = q.size(); i < len; i++) {
//				TreeNode cur = q.poll();
//				sum += cur.val;
//				if (cur.left != null)
//					q.add(cur.left);
//				if (cur.right != null)
//					q.add(cur.right);
//			}
//			if (sum > bestSum) {
//				bestSum = sum;
//				bestLevel = level;
//			}
//			level++;
//		}
//		return bestLevel;
//	}
}
