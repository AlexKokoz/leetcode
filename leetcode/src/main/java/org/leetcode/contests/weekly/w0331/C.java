package org.leetcode.contests.weekly.w0331;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class C {
	public int minCapability(int[] nums, int k) {
		int max = 0;
		for (int num : nums)
			max = Math.max(max, num);
		int ans = max;
		int lo = 1;
		int hi = max;
		while (lo <= hi) {
			int mi = lo + (hi - lo) / 2;
			if (ok(nums, k, mi)) {
				ans = mi;
				hi = mi - 1;
			} else {
				lo = mi + 1;
			}
		}
		return ans;
	}

	boolean ok(int[] nums, int k, int cand) {
		int n = nums.length;
		boolean[] good = new boolean[n];
		for (int i = 0; i < n; i++) {
			if (nums[i] <= cand) {
				good[i] = true;
			}
		}
		for (int i = 0; i < n && k > 0; i++) {
			if (good[i]) {
				k--;
				i++;
			}
		}
		return k == 0;
	}
}
