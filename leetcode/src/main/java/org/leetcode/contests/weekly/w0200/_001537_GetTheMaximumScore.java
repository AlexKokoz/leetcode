package org.leetcode.contests.weekly.w0200;

/**
 * 
 * HARD
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001537_GetTheMaximumScore {
	public int maxSum(int[] nums1, int[] nums2) {
		long mod = 1000000007;
		int m = 10000000;
		boolean[] a = new boolean[m + 1];
		boolean[] b = new boolean[m + 1];
		for (int x : nums1)
			a[x] = true;
		for (int x : nums2)
			b[x] = true;
		long da = 0, db = 0;
		for (int i = 1; i <= m; i++) {
			if (a[i])
				da += i;
			if (b[i])
				db += i;
			if (a[i] && b[i]) {
				da = Math.max(da, db);
				db = da;
			}
		}
		return (int) (Math.max(da, db) % mod);
	}
}
