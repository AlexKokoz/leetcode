package org.leetcode.problems;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 
 * EASY
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000257_BinaryTreePaths {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public List<String> binaryTreePaths(TreeNode root) {
		List<String> list = new LinkedList<>();
		Deque<Integer> deque = new ArrayDeque<>();
		paths(root, list, deque);
		return list;
	}

	void paths(TreeNode node, List<String> list, Deque<Integer> deque) {
		if (node == null)
			return;
		deque.add(node.val);
		if (node.left == node.right) {
			StringBuilder sb = new StringBuilder();
			String sep = "";
			for (int val : deque) {
				sb.append(sep);
				sb.append(val);
				sep = "->";
			}
			list.add(sb.toString());
		} else {
			paths(node.left, list, deque);
			paths(node.right, list, deque);
		}
		deque.removeLast();
	}
}
