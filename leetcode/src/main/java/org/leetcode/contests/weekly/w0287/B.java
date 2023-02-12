package org.leetcode.contests.weekly.w0287;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class B {
	public int maximumCandies(int[] candies, long k) {
		int n = candies.length;
		int lo = 1;
		int hi = 0;
		for (int x : candies)
			hi = Math.max(hi, x);
		int ans = 0;
		while (lo <= hi) {
			int mi = lo + (hi - lo) / 2;
			if (ok(candies, k, mi)) {
				ans = mi;
				lo = mi + 1;
			} else {
				hi = mi - 1;
			}
		}
		return ans;
	}

	boolean ok(int[] nums, long k, int cand) {
		long have = 0;
		for (int num : nums) {
			have += num / cand;
		}
		return have >= k;
	}
}
