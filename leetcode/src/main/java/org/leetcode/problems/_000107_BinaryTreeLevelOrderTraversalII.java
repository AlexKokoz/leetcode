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
public class _000107_BinaryTreeLevelOrderTraversalII {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	class Solution {
		public List<List<Integer>> levelOrderBottom(TreeNode root) {
			List<List<Integer>> ans = new LinkedList<>();
			traverse(root, ans, 1);
			for (int i = 0; i < ans.size() / 2; i++) {
				List<Integer> temp = ans.get(i);
				ans.set(i, ans.get(ans.size() - 1 - i));
				ans.set(ans.size() - 1 - i, temp);
			}
			return ans;
		}

		void traverse(TreeNode node, List<List<Integer>> list, int level) {
			if (node == null)
				return;
			if (node.left == null && node.right == null) {
				if (list.size() < level) {
					list.add(new LinkedList<>());
				}
				list.get(level - 1).add(node.val);
			}
			traverse(node.left, list, level + 1);
			traverse(node.right, list, level + 1);
		}
	}
}
