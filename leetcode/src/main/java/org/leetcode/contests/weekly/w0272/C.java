package org.leetcode.contests.weekly.w0272;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class C {
	public long getDescentPeriods(int[] prices) {
		long ans = 0;
		int n = prices.length;
		for (int l = 0; l < n;) {
			int r = l + 1;
			ans++;
			while (r < n && prices[r - 1] - 1 == prices[r]) {
				ans += r - l + 1;
				r++;
			}
			l = r;
		}
		return ans;
	}
}
