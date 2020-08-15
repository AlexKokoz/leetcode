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

	int ans;

	public int pathSum(TreeNode root, int sum) {
		dfs(root, sum);
		return ans;
	}

	Map<Integer, Integer> dfs(TreeNode node, int sum) {
		if (node == null)
			return new HashMap<>();
		Map<Integer, Integer> left = dfs(node.left, sum);
		Map<Integer, Integer> right = dfs(node.right, sum);
		Map<Integer, Integer> ret = new HashMap<>();
		for (int key : left.keySet()) {
			int nsum = key + node.val;
			if (nsum == sum)
				ans += left.get(key);
			ret.put(nsum, ret.getOrDefault(nsum, 0) + left.get(key));
		}
		for (int key : right.keySet()) {
			int nsum = key + node.val;
			if (nsum == sum)
				ans += right.get(key);
			ret.put(nsum, ret.getOrDefault(nsum, 0) + right.get(key));
		}
		if (node.val == sum)
			ans++;
		ret.put(node.val, ret.getOrDefault(node.val, 0) + 1);
		return ret;
	}
}
