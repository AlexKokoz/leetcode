package org.leetcode.contests.biweekly.bw0082;

/**
 * 
 * EASY
 * 
 * @author Alexandros Kokozidis
 *
 */
public class A {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public boolean evaluateTree(TreeNode node) {
		if (node.left == node.right)
			return node.val == 1;
		boolean left = evaluateTree(node.left);
		boolean right = evaluateTree(node.right);
		return node.val == 2 ? left || right : left && right;
	}

}
