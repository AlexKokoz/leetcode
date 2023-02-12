package org.leetcode.contests.weekly.w0283;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class C {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public TreeNode createBinaryTree(int[][] descriptions) {
		Arrays.sort(descriptions, (a, b) -> {
			if (a[0] != b[0])
				return Integer.compare(a[0], b[0]);
			return Integer.compare(a[1], b[1]);
		});
		// remove dups if any
		{
			int p = 0;
			for (int i = 0; i < descriptions.length; i++) {
				if (i == 0 || !Arrays.equals(descriptions[i], descriptions[i - 1])) {
					descriptions[p++] = descriptions[i];
				}
			}
			descriptions = Arrays.copyOf(descriptions, p);
		}
		Map<Integer, TreeNode> nodes = new HashMap<>();
		Set<Integer> children = new HashSet<>();
		for (int[] desc : descriptions) {
			int p = desc[0], ch = desc[1];
			boolean left = desc[2] == 1;
			if (!nodes.containsKey(p)) {
				nodes.put(p, new TreeNode(p));
			}
			if (!nodes.containsKey(ch)) {
				nodes.put(ch, new TreeNode(ch));
			}
			children.add(ch);
			if (left)
				nodes.get(p).left = nodes.get(ch);
			else
				nodes.get(p).right = nodes.get(ch);
		}
		for (int node : nodes.keySet()) {
			if (!children.contains(node)) {
				return nodes.get(node);
			}
		}
		return null;
	}
}
