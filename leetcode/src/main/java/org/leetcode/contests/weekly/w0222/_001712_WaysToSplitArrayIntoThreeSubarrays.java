package org.leetcode.contests.weekly.w0222;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001712_WaysToSplitArrayIntoThreeSubarrays {
	public int waysToSplit(int[] nums) {
		long mod = 1000000007;
		int n = nums.length;
		long ans = 0;
		long[] cum = new long[n];
		for (int i = 0; i < n; i++)
			cum[i] = nums[i] + (i > 0 ? cum[i - 1] : 0);

		for (int i = 0; i < n - 1; i++) {
			if (cum[i] > cum[n - 1] - cum[i])
				break;
			int lb = lowerBound(2 * cum[i], cum, i + 1, n - 1);
			int ub = lowerBound((cum[n - 1] - cum[i]) / 2 + cum[i] + 1, cum, i + 1, n - 1);
			if (lb == -1 || ub == -1 || ub < lb)
				break;

			ans += ub - lb;
			ans %= mod;
		}
		return (int) ans;
	}

	// returns position of the ceiling value of key between [l, r]; r otherwise
	static int lowerBound(long key, long[] a, int l, int r) {
		assert l <= r;
		int ans = r;
		int lo = l, hi = r;
		while (lo <= hi) {
			int mi = lo + (hi - lo >>> 1);
			if (key <= a[mi]) {
				ans = mi;
				hi = mi - 1;
			} else {
				lo = mi + 1;
			}
		}
		return ans;
	}
}
