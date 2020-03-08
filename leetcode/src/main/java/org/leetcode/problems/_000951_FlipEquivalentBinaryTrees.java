package org.leetcode.problems;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000951_FlipEquivalentBinaryTrees {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public boolean flipEquiv(TreeNode root1, TreeNode root2) {
		return dfs(root1, root2);
	}

	boolean dfs(TreeNode node1, TreeNode node2) {
		if (node1 == null && node2 == null) return true;
		if (node1 == null ^ node2 == null) return false;
		if (node1.val != node2.val) return false;
		return (dfs(node1.left, node2.left) && dfs(node1.right, node2.right))
				|| (dfs(node1.left, node2.right) && dfs(node1.right, node2.left));
	}
}
