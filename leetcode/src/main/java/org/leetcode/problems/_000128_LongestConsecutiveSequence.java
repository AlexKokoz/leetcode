package org.leetcode.problems;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * HARD
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000128_LongestConsecutiveSequence {
	Map<Integer, Integer> child2parent;
	Map<Integer, Integer> parent2size;

	public int longestConsecutive(int[] nums) {
		child2parent = new HashMap<>();
		parent2size = new HashMap<>();
		for (int num : nums) {
			if (child2parent.containsKey(num))
				continue;
			child2parent.put(num, num);
			parent2size.put(num, 1);
			if (child2parent.containsKey(num - 1))
				union(num, num - 1);
			if (parent2size.containsKey(num + 1))
				union(num, num + 1);
		}
		int max = 0;
		for (int x : parent2size.values())
			max = Math.max(max, x);
		return max;
	}

	void union(int v, int w) {
		int p = find(v);
		int q = find(w);
		if (p == q)
			return;
		child2parent.put(p, q);
		parent2size.put(q, parent2size.get(q) + parent2size.get(p));
	}

	int find(int v) {
		while (v != child2parent.get(v)) {
			child2parent.put(v, child2parent.get(child2parent.get(v)));
			v = child2parent.get(v);
		}
		return v;
	}
}
