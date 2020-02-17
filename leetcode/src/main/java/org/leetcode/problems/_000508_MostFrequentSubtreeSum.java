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
public class _000508_MostFrequentSubtreeSum {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public int[] findFrequentTreeSum(TreeNode root) {
		Map<Integer, Integer> sum2freq = new HashMap<>();
		dfs(root, sum2freq);
		int max = Integer.MIN_VALUE;
		int count = 0;
		for (int sum : sum2freq.keySet()) {
			int freq = sum2freq.get(sum);
			if (max < freq) {
				max = freq;
				count = 1;
			} else if (max == freq)
				count++;
		}
		int[] ans = new int[count];
		int index = 0;
		for (int sum : sum2freq.keySet())
			if (sum2freq.get(sum) == max)
				ans[index++] = sum;
		return ans;
	}

	int dfs(TreeNode node, Map<Integer, Integer> sum2freq) {
		if (node == null)
			return 0;
		int curSubtreeSum = node.val + dfs(node.left, sum2freq) + dfs(node.right, sum2freq);
		Integer freq = sum2freq.get(curSubtreeSum);
		if (freq == null)
			sum2freq.put(curSubtreeSum, 1);
		else
			sum2freq.put(curSubtreeSum, freq + 1);
		return curSubtreeSum;
	}
}
