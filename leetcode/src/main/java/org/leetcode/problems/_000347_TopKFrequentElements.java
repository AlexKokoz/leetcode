package org.leetcode.problems;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000347_TopKFrequentElements {
	@SuppressWarnings("unchecked")
	public List<Integer> topKFrequent(int[] nums, int k) {
		final int n = nums.length;
		final Queue<Integer>[] f = new Queue[n + 1];
		for (int i = 0; i < f.length; i++)
			f[i] = new LinkedList<>();
		final Map<Integer, Integer> map = new HashMap<>();
		for (int x : nums) {
			if (map.containsKey(x)) {
				final int nf = map.get(x) + 1;
				map.put(x, nf);
				f[nf].add(x);
			} else {
				map.put(x, 1);
				f[1].add(x);
			}
		}
		final List<Integer> ans = new LinkedList<>();
		outer: for (int fi = f.length - 1; fi >= 0; fi--) {
			final Queue<Integer> q = f[fi];
			if (q.isEmpty())
				continue;
			for (int x : q) {
				if (map.get(x) == fi) {
					ans.add(x);
					k--;
					if (k == 0)
						break outer;
				}
			}
		}
		return ans;
	}
}
