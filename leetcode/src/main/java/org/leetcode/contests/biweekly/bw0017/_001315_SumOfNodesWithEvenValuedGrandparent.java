package org.leetcode.contests.biweekly.bw0017;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001315_SumOfNodesWithEvenValuedGrandparent {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public int sumEvenGrandparent(TreeNode root) {
		if (root == null)
			return 0;
		int[] sum = new int[1];
		traverse(root, root.left, sum);
		traverse(root, root.right, sum);
		return sum[0];
	}

	static void traverse(TreeNode p, TreeNode ch, int[] sum) {
		if (ch == null)
			return;
		if ((p.val & 1) == 0) {
			if (ch.left != null)
				sum[0] += ch.left.val;
			if (ch.right != null)
				sum[0] += ch.right.val;
		}
		if (ch.left != null)
			traverse(ch, ch.left, sum);
		if (ch.right != null)
			traverse(ch, ch.right, sum);
	}
}
