package org.leetcode.problems;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 * EASY
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000653_TwoSumIVBST {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public boolean findTarget(TreeNode root, int k) {
		Set<Integer> set = new HashSet<>();
		return findTarget(root, set, k);
	}

	boolean findTarget(TreeNode node, Set<Integer> set, int k) {
		if (node == null)
			return false;
		int diff = k - node.val;
		if (set.contains(diff))
			return true;
		set.add(diff);
		return findTarget(node.left, set, k) || findTarget(node.right, set, k);
	}
}
