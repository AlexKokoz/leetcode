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
public class _000863_AllNodesDistanceKinBinaryTree {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	TreeNode[] par;
	List<Integer> ans;
	int K;

	public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
		this.K = K;
		par = new TreeNode[501];
		ans = new LinkedList<>();
		dfs(null, root);
		dfs2(null, target, 0);
		return ans;
	}

	void dfs(TreeNode p, TreeNode ch) {
		if (ch == null)
			return;
		par[ch.val] = p;
		dfs(ch, ch.left);
		dfs(ch, ch.right);
	}

	void dfs2(TreeNode p, TreeNode ch, int dist) {
		if (ch == null)
			return;
		if (dist == K) {
			ans.add(ch.val);
			return;
		}
		if (ch.left != p)
			dfs2(ch, ch.left, dist + 1);
		if (ch.right != p)
			dfs2(ch, ch.right, dist + 1);
		if (par[ch.val] != p)
			dfs2(ch, par[ch.val], dist + 1);
	}

}
