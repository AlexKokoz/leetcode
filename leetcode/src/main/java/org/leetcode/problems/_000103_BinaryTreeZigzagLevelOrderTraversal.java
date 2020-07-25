package org.leetcode.problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000103_BinaryTreeZigzagLevelOrderTraversal {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> ans = new ArrayList<>();
		dfs(root, ans, 0);
		for (int i = 1; i < ans.size(); i += 2) {
			Collections.reverse(ans.get(i));
		}
		return ans;
	}

	void dfs(TreeNode node, List<List<Integer>> ans, int depth) {
		if (node == null)
			return;
		if (depth == ans.size())
			ans.add(new ArrayList<>());
		ans.get(depth).add(node.val);
		dfs(node.left, ans, depth + 1);
		dfs(node.right, ans, depth + 1);
	}
}
