package org.leetcode.contests.biweekly.bw0026;

import java.util.TreeMap;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001448_CountGoodNodesΙnBinaryTree {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	int ans = 0;
	TreeMap<Integer, Integer> map;

	public int goodNodes(TreeNode root) {
		map = new TreeMap<>();
		dfs(root);
		return ans;
	}

	void dfs(TreeNode node) {
		if (node == null)
			return;
		Integer ceil = map.ceilingKey(node.val);
		if (ceil == null)
			ans++;
		int count = map.getOrDefault(node.val, 0) + 1;
		map.put(node.val, count);
		dfs(node.left);
		dfs(node.right);
		if (count == 1) {
			map.remove(node.val);
		} else {
			map.put(node.val, count - 1);
		}
	}
}
