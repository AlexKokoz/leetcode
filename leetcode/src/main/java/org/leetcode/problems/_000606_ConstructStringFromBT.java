package org.leetcode.problems;

/**
 * 
 * EASY
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000606_ConstructStringFromBT {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public String tree2str(TreeNode root) {
		StringBuilder sb = new StringBuilder();
		build(root, sb);
		return sb.toString();
	}

	void build(TreeNode node, StringBuilder sb) {
		if (node == null)
			return;
		sb.append(node.val);
		if (node.left != null || node.right != null) {
			sb.append('(');
			build(node.left, sb);
			sb.append(')');
		}
		if (node.right != null) {
			sb.append('(');
			build(node.right, sb);
			sb.append(')');
		}
	}
}
