package org.leetcode.problems;

public class _000988_SmallestStringStartingFromLeaf {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	String min;

	public String smallestFromLeaf(TreeNode root) {
		min = "~";
		dfs(root, "");
		return min;
	}

	void dfs(TreeNode node, String s) {
		if (node == null)
			return;
		char c = toChar(node.val);
		StringBuilder sb = new StringBuilder(s).append(c);
		String reversed = sb.reverse().toString();
		if (node.left == node.right && reversed.compareTo(min) < 0) {
			min = reversed;
			return;
		}
		sb.reverse();
		if (node.left != null)
			dfs(node.left, sb.toString());
		if (node.right != null)
			dfs(node.right, sb.toString());
	}

	char toChar(int i) {
		return (char) ('a' + i);
	}
}
