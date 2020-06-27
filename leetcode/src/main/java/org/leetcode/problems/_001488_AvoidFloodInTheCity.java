package org.leetcode.problems;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001488_AvoidFloodInTheCity {
	public int[] avoidFlood(int[] lakes) {
		int n = lakes.length;
		int[] ans = new int[n];
		Map<Integer, Integer> map = new HashMap<>();
		TreeSet<Integer> set = new TreeSet<>();
		for (int i = 0; i < n; i++) {
			int lake = lakes[i];
			if (lake != 0) {
				ans[i] = -1;
				if (!map.containsKey(lake)) {
					map.put(lake, i);
				} else {
					int prev = map.get(lake);
					Integer cand = set.ceiling(prev);
					if (cand == null)
						return new int[0];
					ans[cand] = lake;
					set.remove(cand);
					map.put(lake, i);
				}
			} else {
				ans[i] = 1;
				set.add(i);
			}
		}
		return ans;
	}

}
