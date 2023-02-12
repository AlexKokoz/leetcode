package org.leetcode.contests.weekly.w0319;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

	public int minimumOperations(TreeNode root) {
		List<List<Integer>> levels = new ArrayList<>();
		dfs(root, levels, 0);
		int ans = 0;
		for (List<Integer> list : levels) {
			List<Integer> sorted = new ArrayList<>(list);
			Collections.sort(sorted);
			Map<Integer, Integer> map = new HashMap<>();
			for (int i = 0; i < list.size(); i++) {
				map.put(list.get(i), i);
			}
			for (int i = 0; i < list.size(); i++) {
				if (list.get(i).equals(sorted.get(i)))
					continue;
				int j = map.get(sorted.get(i));
				int swap = list.get(i);
				list.set(i, list.get(j));
				list.set(j, swap);
				map.put(swap, j);
				ans++;
			}
		}
		return ans;
	}

	void dfs(TreeNode node, List<List<Integer>> levels, int level) {
		if (node == null)
			return;
		if (level == levels.size()) {
			levels.add(new ArrayList<>());
		}
		levels.get(level).add(node.val);
		dfs(node.left, levels, level + 1);
		dfs(node.right, levels, level + 1);
	}
}
