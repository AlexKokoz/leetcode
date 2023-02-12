package org.leetcode.contests.weekly.w0303;

import java.util.Arrays;

/**
 * 
 * HARD
 * 
 * @author Alexandros Kokozidis
 *
 */
public class D {
	public long countExcellentPairs(int[] nums, int k) {
		long ans = 0;

		// remove duplicates
		Arrays.sort(nums);
		int p = 0;
		for (int i = 0; i < nums.length; i++) {
			if (i == 0 || nums[i] != nums[i - 1]) {
				nums[p++] = nums[i];
			}
		}
		nums = Arrays.copyOf(nums, p);
		
		// sort by bitcount
		Integer[] bitcounts = new Integer[nums.length];
		for (int i = 0; i < nums.length; i++) {
			bitcounts[i] = Integer.bitCount(nums[i]);
		}
		Arrays.sort(bitcounts, (a, b) -> {
			return Integer.compare(a, b);
		});

		// two pointers
		int n = bitcounts.length;
		for (int i = n - 1, j = 0; i >= 0 && 2 * bitcounts[i] >= k; i--) {
			while (j < i && bitcounts[i] + bitcounts[j] < k) {
				j++;
			}
			ans += 2 * (i - j) + 1;
		}

		return ans;
	}
}
