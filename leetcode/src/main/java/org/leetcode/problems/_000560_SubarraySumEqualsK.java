package org.leetcode.problems;

public class _000560_SubarraySumEqualsK {
	public int subarraySum(int[] nums, int k) {
		int n = nums.length;
		int[] cum = new int[n];
		cum[0] = nums[0];
		for (int i = 1; i < n; i++)
			cum[i] = cum[i - 1] + nums[i];
		int subarrayCount = 0;
		for (int len = 1; len <= n; len++) {
			for (int l = 0; l <= n - len; l++) {
				int r = l + len - 1;
				int sum = getSum(l, r, cum);
				if (sum == k)
					subarrayCount++;
			}
		}
		return subarrayCount;
	}

	int getSum(int l, int r, int[] cum) {
		return cum[r] - (l == 0 ? 0 : cum[l - 1]);
	}
}
