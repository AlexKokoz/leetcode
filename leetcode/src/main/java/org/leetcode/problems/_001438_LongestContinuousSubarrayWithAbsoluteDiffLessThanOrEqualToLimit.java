package org.leetcode.problems;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001438_LongestContinuousSubarrayWithAbsoluteDiffLessThanOrEqualToLimit {
	public int longestSubarray(int[] nums, int limit) {
		int n = nums.length;

		int[] minrl = new int[n];
		minrl[n - 1] = nums[n - 1];
		for (int i = n - 2; i >= 0; i--) {
			minrl[i] = Math.min(nums[i], minrl[i + 1]);
		}

		int[] maxrl = new int[n];
		maxrl[n - 1] = nums[n - 1];
		for (int i = n - 2; i >= 0; i--) {
			maxrl[i] = Math.max(nums[i], maxrl[i + 1]);
		}

		int ans = 0;

		outer: for (int l = 0; l < n; l++) {
			if (maxrl[l] - minrl[l] <= limit) {
				ans = Math.max(ans, n - l);
				continue;
			}
			int min = Integer.MAX_VALUE;
			int max = 0;
			for (int r = l; r < n; r++) {
				min = Math.min(min, nums[r]);
				max = Math.max(max, nums[r]);
				if (max - min > limit)
					continue outer;
				ans = Math.max(ans, r - l + 1);

			}
		}

		return ans;
	}
}
