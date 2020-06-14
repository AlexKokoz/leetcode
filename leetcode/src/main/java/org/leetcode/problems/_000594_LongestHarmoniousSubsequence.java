package org.leetcode.problems;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * EASY
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000594_LongestHarmoniousSubsequence {
	public int findLHS(int[] nums) {
		int max = 0;
		Map<Integer, Integer> map = new HashMap<>();
		for (int num : nums) {
			map.put(num, map.getOrDefault(num, 0) + 1);
		}
		for (int key : map.keySet()) {
			int cur = map.get(key);
			Integer next = map.get(key + 1);
			if (next != null)
				max = Math.max(max, cur + next);
		}
		return max;
	}
}
