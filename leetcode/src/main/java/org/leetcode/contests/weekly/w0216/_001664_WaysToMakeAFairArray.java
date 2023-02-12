package org.leetcode.contests.weekly.w0216;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001664_WaysToMakeAFairArray {
	public int waysToMakeFair(int[] nums) {
		int n = nums.length;
		int ans = 0;
		int[] even = new int[n + 2];
		int[] odd = new int[n + 2];

		for (int i = 0; i < n; i++) {
			if (i % 2 == 0)
				even[i + 1] = nums[i];
			else
				odd[i + 1] = nums[i];
		}
		for (int i = 1; i < even.length; i++) {
			even[i] += even[i - 1];
			odd[i] += odd[i - 1];
		}
		for (int i = 0; i < n; i++) {
			int se = 0, so = 0;
			if (i % 2 == 0) {
				se = even[i] + sum(i + 1, n + 1, odd);
				so = odd[i] + sum(i + 2, n + 1, even);
			} else {
				se = even[i] + sum(i + 2, n + 1, odd);
				so = odd[i] + sum(i + 1, n + 1, even);
			}
			if (se == so)
				ans++;
		}
		return ans;

	}

	static int sum(int from, int to, int[] cum) {
		return cum[to] - (from == 0 ? 0 : cum[from - 1]);
	}

}
