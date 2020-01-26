package org.leetcode.problems;

import java.util.List;

/**
 * 
 * EASY
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000559_MaxDepthNaryTree {
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

	public int maxDepth(Node root) {
		return root == null ? 0 : maxDepth(root, 1);
	}

	int maxDepth(Node node, int curDepth) {
		int max = curDepth;
		for (Node child : node.children)
			max = Math.max(max, maxDepth(child, curDepth + 1));
		return max;
	}
}
