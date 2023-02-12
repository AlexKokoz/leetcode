package org.leetcode.contests.weekly.w0321;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * HARD
 * 
 * @author Alexandros Kokozidis
 *
 */
public class D {
	public int countSubarrays(int[] nums, int k) {
		int ans = 0;
		int n = nums.length;
		int medianPos = 0;

		for (int i = 0; i < n; i++) {
			if (nums[i] == k) {
				medianPos = i;
				break;
			}
		}

		// Check odd subarrayys
		Map<Integer, Integer> map = new HashMap<>();
		map.put(0, 1);
		for (int i = 0, bal = 0; i < n; i++) {
			if (nums[i] < k)
				bal++;
			else if (nums[i] > k)
				bal--;
			if (i >= medianPos) {
				ans += map.getOrDefault(bal, 0);
			}
			if (i < medianPos)
				map.put(bal, map.getOrDefault(bal, 0) + 1);
		}

		// Check even subarrays
		map = new HashMap<>();
		map.put(0, 1);
		for (int i = 0, bal = 0; i < n; i++) {
			if (nums[i] < k)
				bal++;
			else if (nums[i] > k)
				bal--;
			if (i >= medianPos) {
				ans += map.getOrDefault(bal + 1, 0);
			}
			if (i < medianPos)
				map.put(bal, map.getOrDefault(bal, 0) + 1);
		}

		return ans;
	}
}
