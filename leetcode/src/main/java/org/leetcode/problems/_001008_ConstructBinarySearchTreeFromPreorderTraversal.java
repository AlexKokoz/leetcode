package org.leetcode.problems;

public class _001008_ConstructBinarySearchTreeFromPreorderTraversal {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public TreeNode bstFromPreorder(int[] pre) {
		int n = pre.length;
		return build(pre, 0, n - 1);
	}

	TreeNode build(int[] pre, int l, int r) {
		if (l > r)
			return null;
		TreeNode root = new TreeNode(pre[l]);
		int firstLargestPos = l + 1;
		for (; firstLargestPos <= r && pre[l] > pre[firstLargestPos]; firstLargestPos++)
			;
		root.left = build(pre, l + 1, firstLargestPos - 1);
		root.right = build(pre, firstLargestPos, r);
		return root;
	}

}
