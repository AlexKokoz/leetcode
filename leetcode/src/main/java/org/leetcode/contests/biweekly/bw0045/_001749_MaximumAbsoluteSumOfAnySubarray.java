package org.leetcode.contests.biweekly.bw0045;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001749_MaximumAbsoluteSumOfAnySubarray {
	public int maxAbsoluteSum(int[] nums) {
		int ans = 0;
		int n = nums.length;
		ans = Math.max(ans, maxSubSum(nums)[0]);
		for (int i = 0; i < n; i++)
			nums[i] *= -1;
		ans = Math.max(ans, maxSubSum(nums)[0]);
		return ans;
	}

	// MAX SUBARRAY SUM
	// max, l, r
	static int[] maxSubSum(int[] a) {
		assert a != null;
		assert a.length != 0;

		int n = a.length;
		int gl_max = a[0];
		int gl_l = 0;
		int gl_r = 0;
		int loc_max = gl_max;
		int loc_l = gl_l;

		for (int i = 1; i < n; i++) {
			int plusOne = loc_max + a[i];
			if (a[i] > plusOne) {
				loc_l = i;
				loc_max = a[i];
			} else {
				loc_max = plusOne;
			}

			if (loc_max > gl_max) {
				gl_max = loc_max;
				gl_l = loc_l;
				gl_r = i;
			}
		}
		return new int[] { gl_max, gl_l, gl_r };
	}

}
