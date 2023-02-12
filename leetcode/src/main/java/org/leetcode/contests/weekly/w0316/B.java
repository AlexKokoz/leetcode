package org.leetcode.contests.weekly.w0316;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class B {
	public int subarrayGCD(int[] nums, int k) {
		int n = nums.length;
		int ans = 0;
		boolean[] ok = new boolean[n];
		for (int i = 0; i < n; i++) {
			if (nums[i] % k == 0) {
				ok[i] = true;
			}
		}
		for (int i = 0; i < n; i++) {
			if (!ok[i]) {
				continue;
			}
			int j = i + 1;
			long gcd = nums[i];
			if (gcd == k)
				ans++;
			while (j < n && ok[j]) {
				long gcd2 = gcd(gcd, nums[j]);
				if (gcd2 < k)
					break;
				gcd = gcd2;
				if (gcd == k) {
					ans++;
				}
				j++;
			}
		}
		return ans;
	}

	static long gcd(long a, long b) {
		return a % b == 0 ? b : gcd(b, a % b);
	}
}
