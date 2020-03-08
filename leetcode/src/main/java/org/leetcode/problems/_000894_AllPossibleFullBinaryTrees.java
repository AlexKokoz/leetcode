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
public class _000894_AllPossibleFullBinaryTrees {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	List<TreeNode>[] cache;

	@SuppressWarnings("unchecked")
	public List<TreeNode> allPossibleFBT(int N) {
		List<TreeNode> ans = new LinkedList<>();
		if (N % 2 == 0)
			return ans;
		cache = new List[N + 1];
		dp(N);
		return dp(N);
	}

	List<TreeNode> dp(int n) {
		if (cache[n] != null)
			return cache[n];
		List<TreeNode> list = new LinkedList<>();
		if (n == 1) {
			list.add(new TreeNode(0));
			return list;
		}
		for (int i = 1, mid = (n - 1) / 2; i <= mid; i += 2) {
			int iMirror = n - 1 - i;
			for (TreeNode ch1 : dp(i)) {
				for (TreeNode ch2 : dp(iMirror)) {
					TreeNode root = new TreeNode(0);
					root.left = ch1;
					root.right = ch2;
					list.add(root);
					if (i == iMirror) continue;
					root = new TreeNode(0);
					root.left = ch2;
					root.right = ch1;
					list.add(root);
				}
			}
		}
		cache[n] = list;
		return cache[n];
	}
}
