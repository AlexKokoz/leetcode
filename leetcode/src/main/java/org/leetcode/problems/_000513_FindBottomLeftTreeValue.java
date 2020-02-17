package org.leetcode.problems;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000513_FindBottomLeftTreeValue {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public int findBottomLeftValue(TreeNode root) {
		int[] val_depth = find(root, 0);
		return val_depth[0];
	}

	int[] find(TreeNode node, int curDepth) {
		if (node == null) {
			return new int[] { 0, -1 };
		}
		if (node.left == node.right) {
			int[] val_depth = new int[2];
			val_depth[0] = node.val;
			val_depth[1] = curDepth;
			return val_depth;
		}
		int[] left_val_depth = find(node.left, curDepth + 1);
		int[] right_val_depth = find(node.right, curDepth + 1);
		if (left_val_depth[1] >= right_val_depth[1])
			return left_val_depth;
		else
			return right_val_depth;
	}
}
