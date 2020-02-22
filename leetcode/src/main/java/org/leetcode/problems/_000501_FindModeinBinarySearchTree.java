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
public class _000501_FindModeinBinarySearchTree {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public int[] findMode(TreeNode root) {
		Map<Integer, Integer> map = new HashMap<>();
		mode(root, map);
		int max = Integer.MIN_VALUE;
		int count = 0;
		for (int key : map.keySet()) {
			int freq = map.get(key);
			if (max < freq) {
				max = freq;
				count = 1;
			} else if (max == freq)
				count++;
		}
		int[] ans = new int[count];
		int index = 0;
		for (int key : map.keySet()) {
			int freq = map.get(key);
			if (freq == max)
				ans[index++] = key;
		}
		return ans;
	}

	void mode(TreeNode node, Map<Integer, Integer> map) {
		if (node == null)
			return;
		Integer freq = map.get(node.val);
		if (freq == null)
			map.put(node.val, 1);
		else
			map.put(node.val, freq + 1);
		mode(node.left, map);
		mode(node.right, map);
	}
}
