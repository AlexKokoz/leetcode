package org.leetcode.contests.weekly.w0272;

/**
 * 
 * HARD
 * 
 * @author Alexandros Kokozidis
 *
 */
public class D {
	public int kIncreasing(int[] arr, int k) {
		int ans = 0;
		for (int i = 0; i < k; i++) {
			int[] nums = getArray(arr, k, i);
			ans += solve(nums);
		}
		return ans;
	}

	int solve(int[] a) {
		int n = a.length;
		int p = 0;
		for (int i = 0; i < n; i++) {
			int lo = 0;
			int hi = p - 1;
			int ans = 0;
			while (lo <= hi) {
				int mi = lo + (hi - lo) / 2;
				if (a[i] >= a[mi]) {
					ans = mi + 1;
					lo = mi + 1;
				} else {
					hi = mi - 1;
				}
			}
			if (ans == p) {
				p++;
			}
			a[ans] = a[i];
		}
		return n - p;
	}

	int[] getArray(int[] a, int k, int i) {
		int n = a.length;
		int len = (int) Math.ceil((n - i) / (double) k);
		int[] ret = new int[len];
		int p = 0;
		while (i < n) {
			ret[p++] = a[i];
			i += k;
		}
		return ret;
	}
}
