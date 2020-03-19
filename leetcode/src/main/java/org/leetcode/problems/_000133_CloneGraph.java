package org.leetcode.problems;

import java.util.ArrayList;
import java.util.List;

public class _000133_CloneGraph {
	class Node {
		public int val;
		public List<Node> neighbors;

		public Node() {
			val = 0;
			neighbors = new ArrayList<Node>();
		}

		public Node(int _val) {
			val = _val;
			neighbors = new ArrayList<Node>();
		}

		public Node(int _val, ArrayList<Node> _neighbors) {
			val = _val;
			neighbors = _neighbors;
		}
	}

	Node[] adj;

	public Node cloneGraph(Node node) {
		if (node == null)
			return null;
		adj = new Node[101];
		dfs(node);
		return adj[1];
	}

	void dfs(Node node) {
		int val = node.val;
		if (adj[val] != null)
			return;
		adj[val] = new Node(val);
		for (Node nei : node.neighbors) {
			dfs(nei);
			adj[val].neighbors.add(adj[nei.val]);
		}
	}
}
