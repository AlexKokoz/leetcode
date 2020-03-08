package org.leetcode.problems;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001123_LowestCommonAncestorOfDeepesLeaves {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	Map<Integer, Integer> depth2count;
	int maxDepth;
	int targetCount;
	TreeNode anc;

	public TreeNode lcaDeepestLeaves(TreeNode root) {
		depth2count = new HashMap<>();
		dfs(root, 0);
		maxDepth = -1;
		targetCount = 0;
		for (int d : depth2count.keySet()) {
			if (d > maxDepth) {
				maxDepth = d;
				targetCount = depth2count.get(d);
			}
		}
		dfs2(root, 0);
		return anc;
	}

	void dfs(TreeNode node, int d) {
		if (node == null)
			return;
		if (node.left == node.right) {
			int count = depth2count.getOrDefault(d, 0) + 1;
			depth2count.put(d, count);
		}
		dfs(node.left, d + 1);
		dfs(node.right, d + 1);
	}

	int dfs2(TreeNode node, int d) {
		if (node == null)
			return 0;
		if (node.left == node.right) {
			if (d == maxDepth) {
				if (targetCount == 1)
					anc = node;
				return 1;
			} else {
				return 0;
			}
		}

		int sum = dfs2(node.left, d + 1) + dfs2(node.right, d + 1);
		if (sum == targetCount && anc == null)
			anc = node;
		return sum;
	}

//	TreeNode[] nodes;
//	TreeNode[] parent;
//	int[] depth;
//	TreeNode anc;
//	int ancDepth;
//	boolean[] marked;
//
//	public TreeNode lcaDeepestLeaves(TreeNode root) {
//		this.nodes = new TreeNode[1001];
//		this.parent = new TreeNode[1001];
//		this.depth = new int[1001];
//		Arrays.fill(depth, -1);
//		dfs(null, root, 0);
//
//		int max = -1;
//		for (int x : depth)
//			max = Math.max(max, x);
//
//		this.anc = null;
//		this.ancDepth = -1;
//		this.marked = new boolean[1001];
//		for (int i = 1; i < depth.length; i++) {
//			if (depth[i] == max) {
//				dfsr(i);
//			}
//		}
//		return anc;
//	}
//
//	void dfs(TreeNode p, TreeNode ch, int d) {
//		if (ch == null)
//			return;
//		nodes[ch.val] = ch;
//		parent[ch.val] = p;
//		depth[ch.val] = d;
//		dfs(ch, ch.left, d + 1);
//		dfs(ch, ch.right, d + 1);
//	}
//
//	void dfsr(int val) {
//		if (anc == null)
//			anc = nodes[val];
//		marked[val] = true;
//		TreeNode p = parent[val];
//		while (p != null) {
//			if (marked[p.val])
//				break;
//			marked[p.val] = true;
//			p = parent[p.val];
//		}
//		if (p != null) {
//			if (depth[p.val] > ancDepth) {
//				ancDepth = depth[p.val];
//				anc = p;
//			}
//		}
//	}

}
