package org.leetcode.contests.biweekly.bw0038;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 
 * EASY
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001636_SortArrayByIncreasingFrequency {
	public int[] frequencySort(int[] nums) {
		int n = nums.length;
		Integer[] a = new Integer[n];
		for (int i = 0; i < n; i++)
			a[i] = nums[i];
		int[] ct = new int[202];
		for (int num : nums)
			ct[num + 100]++;
		Arrays.sort(a, new Comparator<Integer>() {
			public int compare(Integer a, Integer b) {
				if (ct[100 + a] != ct[100 + b])
					return ct[100 + a] - ct[100 + b];
				return b - a;
			}
		});
		for (int i = 0; i < n; i++)
			nums[i] = a[i];
		return nums;
	}

}
