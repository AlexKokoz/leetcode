package org.leetcode.problems;

import java.util.Map.Entry;
import java.util.TreeMap;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001530_NumberOfGoodLeafNodesPairs {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	int ans;

	public int countPairs(TreeNode root, int distance) {
		dfs(root, distance, 0);
		return ans;
	}

	TreeMap<Integer, Integer> dfs(TreeNode node, int distance, int depth) {
		if (node == null)
			return new TreeMap<>();
		if (node.left == node.right) {
			TreeMap<Integer, Integer> mp = new TreeMap<>();
			mp.put(depth, 1);
			return mp;
		}
		TreeMap<Integer, Integer> left = dfs(node.left, distance, depth + 1);
		TreeMap<Integer, Integer> right = dfs(node.right, distance, depth + 1);
		for (Entry<Integer, Integer> entry : left.entrySet()) {
			int keyFrom = entry.getKey();
			int valFrom = entry.getValue();
			int floor = depth + 1;
			int ceil = depth + distance - (keyFrom - depth);
			Integer keyTo = right.ceilingKey(floor);
			while (keyTo != null && keyTo <= ceil) {
				int valTo = right.get(keyTo);
				ans += valFrom * valTo;
				keyTo = right.ceilingKey(keyTo + 1);
			}
		}

		for (int key : right.keySet()) {
			left.put(key, left.getOrDefault(key, 0) + right.get(key));
		}
		return left;
	}

}
