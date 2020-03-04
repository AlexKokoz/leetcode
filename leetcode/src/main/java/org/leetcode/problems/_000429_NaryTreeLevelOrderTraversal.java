package org.leetcode.problems;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000429_NaryTreeLevelOrderTraversal {

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

	public List<List<Integer>> levelOrder(Node root) {
		List<List<Integer>> list = new LinkedList<>();
		Queue<Node> q = new LinkedList<>();
		if (root == null) return list;
		q.add(root);
		while(!q.isEmpty()) {
			List<Integer> curLevelRow = new LinkedList<>();
			for (int i = 0, size = q.size(); i < size; i++) {
				Node curNode = q.poll();
				curLevelRow.add(curNode.val);
				for (Node child : curNode.children)
					q.add(child);
			}
			list.add(curLevelRow);
		}
		return list;
	}
}
