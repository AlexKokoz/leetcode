package org.leetcode.problems;

import java.util.ArrayList;
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

	List<int[]> minmax;

	public int widthOfBinaryTree(TreeNode root) {
		minmax = new ArrayList<>();
		dfs(root, 1, 0);
		int ans = 0;
		for (int[] row : minmax)
			ans = Math.max(ans, row[1] - row[0] + 1);
		return ans;
	}

	void dfs(TreeNode node, int id, int level) {
		if (node == null)
			return;
		if (level == minmax.size()) {
			minmax.add(new int[] { Integer.MAX_VALUE, Integer.MIN_VALUE });
		}
		int[] a = minmax.get(level);
		a[0] = Math.min(a[0], id);
		a[1] = Math.max(a[1], id);
		int nid = id << 1;
		dfs(node.left, nid, level + 1);
		dfs(node.right, nid + 1, level + 1);
	}
}
