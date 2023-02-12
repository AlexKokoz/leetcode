package org.leetcode.contests.weekly.w0317;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * HARD
 * 
 * @author Alexandros Kokozidis
 *
 */
public class D {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public int[] treeQueries(TreeNode root, int[] queries) {
		int n = size(root);
		int m = queries.length;
		int[] ans = new int[m];
		int[] maxHeight = new int[n + 1];
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < m; i++) {
			map.put(queries[i], 0);
		}
		dfs(root, maxHeight);
		dfs2(root, maxHeight, 0, 0, map);
		for (int i = 0; i < m; i++) {
			ans[i] = map.getOrDefault(queries[i], 0);
		}
		return ans;
	}

	int size(TreeNode node) {
		return node == null ? 0 : 1 + size(node.left) + size(node.right);
	}

	void dfs(TreeNode node, int[] maxHeight) {
		if (node == null)
			return;
		if (node.left != null) {
			dfs(node.left, maxHeight);
			maxHeight[node.val] = Math.max(maxHeight[node.val], maxHeight[node.left.val] + 1);
		}
		if (node.right != null) {
			dfs(node.right, maxHeight);
			maxHeight[node.val] = Math.max(maxHeight[node.val], maxHeight[node.right.val] + 1);
		}
	}

	void dfs2(TreeNode node, int[] maxHeight, int otherBranchHeight, int above, Map<Integer, Integer> map) {
		if (node == null)
			return;
		if (node.left != null) {
			int newOtherBranchHeight = Math.max(above, otherBranchHeight);
			int cand = newOtherBranchHeight;
			if (node.right != null) {
				newOtherBranchHeight = Math.max(newOtherBranchHeight,
						above + maxHeight[node.right.val] + 1);
				cand = Math.max(cand, above + maxHeight[node.right.val] + 1);
			}
			map.put(node.left.val, cand);
			dfs2(node.left, maxHeight, newOtherBranchHeight, above + 1, map);
		}
		if (node.right != null) {
			int newOtherBranchHeight = Math.max(above, otherBranchHeight);
			int cand = newOtherBranchHeight;
			if (node.left != null) {
				newOtherBranchHeight = Math.max(newOtherBranchHeight,
						above + maxHeight[node.left.val] + 1);
				cand = Math.max(cand, above + maxHeight[node.left.val] + 1);
			}
			map.put(node.right.val, cand);
			dfs2(node.right, maxHeight, newOtherBranchHeight, above + 1, map);
		}
	}
}
