package org.leetcode.contests.weekly.w0280;

import java.util.Arrays;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class C {
	public long minimumRemoval(int[] beans) {
		int n = beans.length;
		long ans = Long.MAX_VALUE;
		Arrays.sort(beans);
		long[] cum = new long[n + 1];
		for (int i = 0; i < n; i++)
			cum[i + 1] = cum[i] + beans[i];
		for (int l = 0; l < n;) {
			int r = l;
			while (r < n && beans[r] == beans[l])
				r++;
			long cand = cum[l] + (cum[n] - cum[r]) - ((long) beans[l] * (n - r));
			ans = Math.min(ans, cand);
			l = r;
		}
		return ans == Long.MAX_VALUE ? 0 : ans;
	}
}
