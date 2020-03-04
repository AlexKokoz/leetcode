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
public class _000113_PathSumII {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		List<List<Integer>> paths = new LinkedList<>();
		List<Integer> currentPath = new LinkedList<>();
		getPaths(root, sum, 0, paths, currentPath);
		return paths;
	}

	void getPaths(TreeNode node, int targetSum, int currentSum, List<List<Integer>> paths, List<Integer> currentPath) {
		if (node == null)
			return;
		currentSum += node.val;
		currentPath.add(node.val);
		if (node.left == node.right) {
			if (currentSum == targetSum) {
				List<Integer> targetPath = new LinkedList<>(currentPath);
				paths.add(targetPath);
			}
			currentPath.remove(currentPath.size() - 1);
			return;
		}
		getPaths(node.left, targetSum, currentSum, paths, currentPath);
		getPaths(node.right, targetSum, currentSum, paths, currentPath);

		currentPath.remove(currentPath.size() - 1);
	}
}
