package org.leetcode.problems;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001343_MaximumProductOfSplittedBinaryTree {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public int maxProduct(TreeNode root) {
		long mod = 1000000007;
		int sum = sum(root);
		return (int) (maxProd(root, sum)[1] % mod);
	}

	int sum(TreeNode node) {
		if (node == null)
			return 0;
		if (node.left == null && node.right == null)
			return node.val;
		return node.val + sum(node.left) + sum(node.right);
	}

	long[] maxProd(TreeNode node, int sum) {
		if (node == null)
			return new long[] { 0, Integer.MIN_VALUE };
		if (node.left == null && node.right == null) {
			long[] ans = new long[2];
			ans[0] = node.val;
			ans[1] = (sum - ans[0]) * ans[0];
			return ans;
		}
		long[] left = maxProd(node.left, sum);
		long[] right = maxProd(node.right, sum);
		long[] ans = new long[2];
		ans[0] = node.val + left[0] + right[0];
		long curProd = ans[1] = (sum - ans[0]) * ans[0];
		ans[1] = Math.max(curProd, Math.max(left[1], right[1]));
		return ans;
	}
}
