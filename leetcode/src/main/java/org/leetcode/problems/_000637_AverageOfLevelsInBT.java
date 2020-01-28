package org.leetcode.problems;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 
 * EASY
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000637_AverageOfLevelsInBT {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public List<Double> averageOfLevels(TreeNode root) {
		List<Double> avg = new LinkedList<>();
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		while (!q.isEmpty()) {
			double levelSum = 0;
			int count = q.size();
			for (int i = 0; i < count; i++) {
				TreeNode cur = q.poll();
				levelSum += cur.val;
				if (cur.left != null)
					q.add(cur.left);
				if (cur.right != null)
					q.add(cur.right);
			}
			avg.add(levelSum / count);
		}
		return avg;
	}
}
