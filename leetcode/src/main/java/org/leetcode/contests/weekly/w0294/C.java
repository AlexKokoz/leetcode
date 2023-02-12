package org.leetcode.contests.weekly.w0294;

import java.util.Arrays;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class C {
	public int minimumLines(int[][] nums) {
		int n = nums.length;
		if (n == 1)
			return 0;
		Arrays.sort(nums, (a, b) -> Integer.compare(a[0], b[0]));
		int ans = 1;
		for (int i = 2; i < n; i++) {
			if (!cl(nums, i - 2, i - 1, i))
				ans++;
		}
		return ans;

	}

	boolean cl(int[][] nums, int p1, int p2, int p3) {
		return (long) (nums[p3][1] - nums[p1][1])
				* (nums[p2][0] - nums[p1][0]) == (long) (nums[p2][1] - nums[p1][1])
						* (nums[p3][0] - nums[p1][0]);
	}
}
