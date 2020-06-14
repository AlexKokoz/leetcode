package org.leetcode.problems;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000368_LargestDivisibleSubset {
	public List<Integer> largestDivisibleSubset(int[] nums) {
		int n = nums.length;
		int[] prev = new int[n];
		int[] size = new int[n];
		int max = 0;
		int start = -1;

		Arrays.fill(prev, -1);
		Arrays.fill(size, 1);
		Arrays.sort(nums);
		for (int i = 0; i < n; i++) {
			for (int j = i - 1; j >= 0; j--) {
				if (nums[i] % nums[j] == 0 && size[j] + 1 > size[i]) {
					size[i] = size[j] + 1;
					prev[i] = j;
				}
			}
			if (max < size[i]) {
				max = size[i];
				start = i;
			}
		}

		List<Integer> ans = new LinkedList<>();
		while (start != -1) {
			ans.add(nums[start]);
			start = prev[start];
		}
		return ans;
	}
}
