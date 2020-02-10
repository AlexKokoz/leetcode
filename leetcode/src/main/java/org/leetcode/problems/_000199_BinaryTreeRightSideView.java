package org.leetcode.problems;

import java.util.LinkedList;
import java.util.List;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000199_BinaryTreeRightSideView {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public List<Integer> rightSideView(TreeNode root) {
		List<Integer> list = new LinkedList<>();
		fillRightView(root, list, 1);
		return list;
	}

	void fillRightView(TreeNode node, List<Integer> list, int level) {
		if (node == null)
			return;
		if (level > list.size())
			list.add(node.val);
		else
			list.set(level - 1, node.val);
		fillRightView(node.left, list, level + 1);
		fillRightView(node.right, list, level + 1);
	}
}
