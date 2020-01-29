package org.leetcode.problems;

/**
 * EASY
 * 
 * @author AccelSprinter
 *
 */
public class _000108_ConvertSortedArrayToBST {

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public TreeNode sortedArrayToBST(int[] nums) {
		TreeNode root = build(nums, 0, nums.length - 1);
		return root;
	}

	static TreeNode build(int[] arr, int lo, int hi) {
		if (lo > hi)
			return null;
		final int mi = (lo + hi) / 2;
		final TreeNode root = new TreeNode(arr[mi]);
		root.left = build(arr, lo, mi - 1);
		root.right = build(arr, mi + 1, hi);
		return root;
	}

}
