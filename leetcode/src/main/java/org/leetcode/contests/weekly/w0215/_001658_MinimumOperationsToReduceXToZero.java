package org.leetcode.contests.weekly.w0215;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001658_MinimumOperationsToReduceXToZero {
	public int minOperations(int[] nums, int x) {
		int n = nums.length;
		int ans = Integer.MAX_VALUE;
		Map<Integer, Integer> map = new HashMap<>();
		int sum = 0;
		for (int i = 0; i < n; i++) {
			sum += nums[i];
			if (sum == x)
				ans = Math.min(ans, i + 1);
			map.put(sum, i + 1);
		}
		if (sum < x)
			return -1;
		sum = 0;
		for (int i = n - 1; i >= 0; i--) {
			sum += nums[i];
			if (sum == x)
				ans = Math.min(ans, n - i);
			if (map.containsKey(x - sum))
				ans = Math.min(ans, map.get(x - sum) + n - i);
		}

		return ans == Integer.MAX_VALUE ? -1 : ans;
	}
}
