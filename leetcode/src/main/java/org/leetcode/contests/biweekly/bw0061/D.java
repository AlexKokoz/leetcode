package org.leetcode.contests.biweekly.bw0061;

import java.util.Arrays;

/**
 * 
 * HARD
 * 
 * @author Alexandros Kokozidis
 *
 */
public class D {
	public int minOperations(int[] nums) {
		Arrays.sort(nums);
		int n = nums.length;
		int ans = n;
		int[][] es = new int[n][];

		// remove duplicates
		{
			int p = 0;
			for (int i = 0; i < n; i++) {
				if (i == 0 || nums[i] != nums[i - 1])
					nums[p++] = nums[i];
			}
			nums = Arrays.copyOf(nums, p);
		}
		int p = 0;
		for (int l = 0; l < nums.length;) {
			int r = l + 1;
			while (r < nums.length && nums[r] == nums[r - 1] + 1) {
				r++;
			}
			es[p++] = new int[] { nums[l], nums[r - 1] };
			l = r;
		}
		es = Arrays.copyOf(es, p);
		int have = 0;
		for (int i = 0, j = 0; i < p; i++) {
			int end = es[i][0] + n - 1;
			while (j < p && es[j][1] <= end) {
				have += es[j][1] - es[j][0] + 1;
				j++;
			}
			int have2 = have;
			if (j < p && es[j][0] <= end) {
				have2 += end - es[j][0] + 1;
			}
			ans = Math.min(ans, n - have2);
			have -= es[i][1] - es[i][0] + 1;
		}
		return ans;
	}
}
