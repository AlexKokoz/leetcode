package org.leetcode.problems;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001261_FindElementsInAContaminatedBinaryTree {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	class FindElements {
		Set<Integer> set;

		public FindElements(TreeNode root) {
			set = new HashSet<>();
			retrieveValues(root, 0);
		}
		
		private void retrieveValues(TreeNode node, int curValue) {
			if (node == null) return;
			set.add(curValue);
			retrieveValues(node.left, curValue * 2 + 1);
			retrieveValues(node.right, curValue * 2 + 2);
		}

		public boolean find(int target) {
			return set.contains(target);
		}
	}

}
