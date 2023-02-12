package org.leetcode.contests.biweekly.bw0080;

/**
 * 
 * HARD
 * 
 * @author Alexandros Kokozidis
 *
 */
public class D {
	public long countSubarrays(int[] nums, long k) {
		int n = nums.length;
		long ans = 0;
		int l = 0;
		int r = 0;
		long sum = 0;
		int prevr = -1;
		while (r < n) {
			if (nums[r] >= k) {
				r++;
				l = r;
				sum = 0;
				continue;
			}
			while (r < n) {
				sum += nums[r];
				if (sum * (r - l + 1) >= k) {
					break;
				}
				r++;
			}
			long len = r - l;
			if (l > prevr) {
				ans += len * (len + 1) / 2;
			} else {
				long overlap = prevr - l + 1;
				ans += len * (len + 1) / 2 - overlap * (overlap + 1) / 2;
			}
			if (r == n)
				break;
			prevr = r - 1;
			while (l < r) {
				sum -= nums[l++];
				if (sum * (r - l + 1) < k) {
					break;
				}
			}
			sum -= nums[r];
		}
		return ans;
	}

}
