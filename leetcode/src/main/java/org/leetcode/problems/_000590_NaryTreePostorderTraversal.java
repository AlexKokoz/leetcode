package org.leetcode.problems;

import java.util.LinkedList;
import java.util.*;

/**
 * 
 * EASY
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000590_NaryTreePostorderTraversal {
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
	}

	// ---------------------------------------------------------
	// ---- RECURSIVE ------------------------------------------
	// ---------------------------------------------------------
	public List<Integer> postorder(Node root) {
		List<Integer> list = new LinkedList<>();
		postorder(root, list);
		return list;
	}

	void postorder(Node node, List<Integer> list) {
		if (node == null)
			return;
		for (Node child : node.children)
			postorder(child, list);
		list.add(node.val);
	}

	// ---------------------------------------------------------
	// ---- ITERATIVE ------------------------------------------
	// ---------------------------------------------------------
//	public List<Integer> postorder(Node root) {
//		List<Integer> ans = new LinkedList<>();
//		if (root == null)
//			return ans;
//		Stack<Node> nodes = new Stack<>();
//		Stack<Integer> vals = new Stack<>();
//		nodes.add(root);
//		while (!nodes.isEmpty()) {
//			Node node = nodes.pop();
//			vals.push(node.val);
//			for (int i = 0; i < node.children.size(); i++) {
//				nodes.add(node.children.get(i));
//			}
//		}
//		while (!vals.isEmpty())
//			ans.add(vals.pop());
//		return ans;
//	}
}
