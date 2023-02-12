package org.leetcode.contests.weekly.w0220;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001695_MaximumErasureValue {
	public int maximumUniqueSubarray(int[] nums) {
		int n = nums.length;
		Map<Integer, Integer> map = new HashMap<>();
		int max = Integer.MIN_VALUE;
		int[] pre = new int[n + 1];
		for (int i = 0; i < n; i++)
			pre[i + 1] = pre[i] + nums[i];
		int last = 0;
		for (int i = 0; i < n; i++) {
			last = Math.max(last, map.getOrDefault(nums[i], -1) + 1);
			int cand = pre[i + 1] - pre[last];
			max = Math.max(max, cand);
			map.put(nums[i], i);
		}

		return max;
	}

}
