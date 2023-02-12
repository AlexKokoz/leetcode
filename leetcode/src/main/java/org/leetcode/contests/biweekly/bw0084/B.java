package org.leetcode.contests.biweekly.bw0084;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class B {
	public long countBadPairs(int[] nums) {
		Map<Integer, Long> map = new HashMap<>();
		long ans = 0;
		int n = nums.length;
		for (int i = 0; i < n; i++) {
			int sum = i - nums[i];
			ans += i - map.getOrDefault(sum, 0L);
			map.put(sum, map.getOrDefault(sum, 0L) + 1);
		}
		return ans;
	}
}
