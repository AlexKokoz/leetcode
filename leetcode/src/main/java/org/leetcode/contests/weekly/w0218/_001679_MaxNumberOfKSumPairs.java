package org.leetcode.contests.weekly.w0218;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001679_MaxNumberOfKSumPairs {
	public int maxOperations(int[] nums, int k) {
		Map<Integer, Integer> map = new HashMap<>();
		int ans = 0;
		for (int num : nums) {
			int count = map.getOrDefault(num, 0);
			if (count > 0) {
				ans++;
				if (count == 1)
					map.remove(num);
				else
					map.put(num, count - 1);
			} else {
				map.put(k - num, map.getOrDefault(k - num, 0) + 1);
			}
		}

		return ans;
	}
}
