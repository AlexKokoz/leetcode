package org.leetcode.contests.weekly.w0307;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class C {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public int amountOfTime(TreeNode root, int start) {
		Map<Integer, List<Integer>> adj = new HashMap<>();
		dfs1(root, adj);
		Map<Integer, Integer> dist = new HashMap<>();
		Deque<Integer> dq = new ArrayDeque<>();
		dist.put(start, 0);
		dq.add(start);
		while (!dq.isEmpty()) {
			int cur = dq.poll();
			for (int next : adj.getOrDefault(cur, new ArrayList<>())) {
				if (dist.getOrDefault(next, Integer.MAX_VALUE) > dist.get(cur) + 1) {
					dist.put(next, dist.get(cur) + 1);
					dq.add(next);
				}
			}
		}
		int ans = 0;
		for (int v : dist.values()) {
			ans = Math.max(ans, v);
		}
		return ans;
	}

	void dfs1(TreeNode node, Map<Integer, List<Integer>> adj) {
		if (node == null)
			return;
		if (node.left != null) {
			adj.computeIfAbsent(node.val, l -> new ArrayList<>()).add(node.left.val);
			adj.computeIfAbsent(node.left.val, l -> new ArrayList<>()).add(node.val);
		}

		if (node.right != null) {
			adj.computeIfAbsent(node.val, l -> new ArrayList<>()).add(node.right.val);
			adj.computeIfAbsent(node.right.val, l -> new ArrayList<>()).add(node.val);
		}

		dfs1(node.left, adj);
		dfs1(node.right, adj);
	}
}
