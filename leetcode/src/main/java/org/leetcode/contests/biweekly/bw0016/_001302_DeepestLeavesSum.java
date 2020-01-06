package org.leetcode.contests.biweekly.bw0016;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001302_DeepestLeavesSum {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public int deepestLeavesSum(TreeNode root) {
		final List<Node> leaves = new LinkedList<>();
		sum(root, leaves, 0);
		Collections.sort(leaves, new Comparator<Node>() {
			public int compare(Node a, Node b) {
					if (a.depth < b.depth) return 1;
					if (a.depth > b.depth) return -1;
					return 0;
			}
		});
		int ans = 0;
		ans += leaves.get(0).val;
		for (int i = 1; i < leaves.size();i++)
			if (leaves.get(i).depth == leaves.get(0).depth)
				ans += leaves.get(i).val;
			else break;
		return ans;
	}

	static void sum(TreeNode node, List<Node> leaves, int depth) {
		if (node == null)
			return;
		if (node.right == null && node.left == null) {
			Node leaf = new Node(node.val, depth);
			leaves.add(leaf);
		}
		sum(node.left, leaves, depth + 1);
		sum(node.right, leaves, depth + 1);
	}

	static class Node {
		int val;
		int depth;

		public Node(int _val, int _depth) {
			this.val = _val;
			this.depth = _depth;
		}
	}
}
