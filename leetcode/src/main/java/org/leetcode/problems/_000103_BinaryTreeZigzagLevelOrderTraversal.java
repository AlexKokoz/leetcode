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
public class _000103_BinaryTreeZigzagLevelOrderTraversal {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> ans = new LinkedList<>();
		if (root == null)
			return ans;
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		while (!q.isEmpty()) {
			List<Integer> currentLevel = new LinkedList<>();
			for (int i = 0, len = q.size(); i < len; i++) {
				TreeNode currentNode = q.poll();
				currentLevel.add(currentNode.val);
				if (currentNode.left != null)
					q.add(currentNode.left);
				if (currentNode.right != null)
					q.add(currentNode.right);
			}
			ans.add(currentLevel);
		}
		for (int i = 1; i < ans.size(); i += 2)
			reverse(ans.get(i));
		return ans;
	}

	void reverse(List<Integer> list) {
		int n = list.size();
		for (int i = 0; i < n / 2; i++) {
			int temp = list.get(i);
			list.set(i, list.get(n - 1 - i));
			list.set(n - 1 - i, temp);
		}
	}
}
