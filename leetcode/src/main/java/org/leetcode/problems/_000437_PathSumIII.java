package org.leetcode.problems;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * EASY
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000437_PathSumIII {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	int count;

	public int pathSum(TreeNode root, int sum) {
		Map<Integer, Integer> map = new HashMap<>();
		count(root, sum, map);
		return count;
	}

	void count(TreeNode node, int sum, Map<Integer, Integer> map) {
		if (node == null)
			return;
		Map<Integer, Integer> nmap = new HashMap<>();
		for (int x : map.keySet()) {
			int f = map.get(x);
			int nx = x - node.val;
			if (nx == 0)
				count += f;
			nmap.put(nx, f);
		}
		if (node.val == sum)
			count++;
		int nx = sum - node.val;
		Integer f = nmap.get(nx);
		nmap.put(nx, (f == null ? 1 : f + 1));
		Map<Integer, Integer> copyMap = new HashMap<>(nmap);
		count(node.left, sum, nmap);
		count(node.right, sum, copyMap);
	}
}
