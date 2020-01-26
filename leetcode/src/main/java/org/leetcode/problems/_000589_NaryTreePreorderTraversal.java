package org.leetcode.problems;

import java.util.LinkedList;
import java.util.*;

/**
 * 
 * EASY
 * 
 * @author akokozidis
 *
 */
public class _000589_NaryTreePreorderTraversal {

	class Node {
		public int val;
		public List<Node> children;

		public Node() {
		}

		public Node(int _val) {
			val = _val;
		}

		public Node(int _val, List<Node> _children) {
			val = _val;
			children = _children;
		}
	};

	// ---------------------------------------------------------
	// ---- RECURSIVE ------------------------------------------
	// ---------------------------------------------------------
	public List<Integer> preorder(Node root) {
		List<Integer> list = new LinkedList<>();
		preorder(root, list);
		return list;
	}

	void preorder(Node node, List<Integer> list) {
		if (node == null)
			return;
		for (int i = node.children.size() - 1; i >= 0; i--)
			preorder(node.children.get(i), list);
		list.add(node.val);
	}

	// ---------------------------------------------------------
	// ---- ITERATIVE ------------------------------------------
	// ---------------------------------------------------------
//	public List<Integer> preorder(Node root) {
//		final Stack<Node> nodes = new Stack<>();
//		final List<Integer> ans = new LinkedList<>();
//		if (root == null)
//			return ans;
//		nodes.add(root);
//		while (!nodes.isEmpty()) {
//			final Node cur = nodes.pop();
//			ans.add(cur.val);
//			for (int i = cur.children.size() - 1; i >= 0; i--)
//				nodes.add(cur.children.get(i));
//		}
//		return ans;
//	}

}
