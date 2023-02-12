package org.leetcode.contests.weekly.w0308;

import java.util.Arrays;

/**
 * 
 * EASY
 * 
 * @author Alexandros Kokozidis
 *
 */
public class A {
	public int[] answerQueries(int[] nums, int[] queries) {
		int n = nums.length;
		int m = queries.length;
		int[] ans = new int[m];
		Arrays.sort(nums);
		int[] cum = new int[n + 1];
		for (int i = 0; i < n; i++) {
			cum[i + 1] = cum[i] + nums[i];
		}
		for (int q = 0; q < m; q++) {
			int lo = 0;
			int hi = n;
			int pos = 0;
			while (lo <= hi) {
				int mi = lo + (hi - lo) / 2;
				if (cum[mi] <= queries[q]) {
					pos = mi;
					lo = mi + 1;
				} else {
					hi = mi - 1;
				}
			}
			ans[q] = pos;
		}
		return ans;
	}
}
