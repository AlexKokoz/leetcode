package org.leetcode.problems;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000654_MaximumBinaryTree {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public TreeNode constructMaximumBinaryTree(int[] nums) {
		return build(nums, 0, nums.length - 1);
	}

	TreeNode build(int[] a, int l, int r) {
		if (l > r)
			return null;
		int max = Integer.MIN_VALUE;
		int pos = -1;
		for (int i = l; i <= r; i++) {
			if (a[i] > max) {
				max = a[i];
				pos = i;
			}
		}
		TreeNode node = new TreeNode(max);
		node.left = build(a, l, pos - 1);
		node.right = build(a, pos + 1, r);
		return node;
	}

}
