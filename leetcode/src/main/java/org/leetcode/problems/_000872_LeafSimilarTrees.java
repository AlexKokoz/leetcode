package org.leetcode.problems;

import java.util.LinkedList;
import java.util.List;

/**
 * 
 * EASY
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000872_LeafSimilarTrees {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public boolean leafSimilar(TreeNode root1, TreeNode root2) {
		List<Integer> leaves1 = new LinkedList<>();
		List<Integer> leaves2 = new LinkedList<>();
		getLeaves(root1, leaves1);
		getLeaves(root2, leaves2);
		if (leaves1.size() != leaves2.size())
			return false;
		for (int i = 0; i < leaves1.size(); i++)
			if (leaves1.get(i) != leaves2.get(i))
				return false;
		return true;
	}

	void getLeaves(TreeNode node, List<Integer> list) {
		if (node == null)
			return;
		getLeaves(node.left, list);
		if (node.left == node.right)
			list.add(node.val);
		getLeaves(node.right, list);
	}

}
