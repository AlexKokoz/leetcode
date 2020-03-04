package org.leetcode.problems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * EASY
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001365_HowManyNumbersAreSmallerThanTheCurrentNumber {
	public int[] smallerNumbersThanCurrent(int[] nums) {
		int n = nums.length;
		int[] cp = Arrays.copyOf(nums, n);
		Arrays.sort(cp);
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < n; i++) {
			if (i == 0 || cp[i] != cp[i - 1])
				map.put(cp[i], i);
		}
		int[] ans = new int[nums.length];
		for (int i = 0; i < nums.length; i++)
			ans[i] = map.get(nums[i]);
		return ans;
	}

}


