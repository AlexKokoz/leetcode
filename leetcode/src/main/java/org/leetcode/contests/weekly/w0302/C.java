package org.leetcode.contests.weekly.w0302;

import java.util.Arrays;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class C {
	public int[] smallestTrimmedNumbers(String[] nums, int[][] queries) {
		int nq = queries.length;
		int n = nums.length;
		int m = nums[0].length();
		int[] ans = new int[nq];
		Integer[] is = new Integer[n];
		for (int i = 0; i < n; i++) {
			is[i] = i;
		}
		for (int q = 0; q < nq; q++) {
			int k = queries[q][0] - 1;
			int trim = queries[q][1];
			int start = m - trim;
			Arrays.sort(is, (a, b) -> {

				for (int i = start; i < m; i++) {
					if (nums[a].charAt(i) != nums[b].charAt(i)) {
						return Character.compare(nums[a].charAt(i), nums[b].charAt(i));
					}
				}
				return Integer.compare(a, b);
			});
			ans[q] = is[k];
		}
		return ans;
	}
}
