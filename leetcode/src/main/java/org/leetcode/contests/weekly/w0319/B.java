package org.leetcode.contests.weekly.w0319;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class B {
	public int subarrayLCM(int[] nums, int k) {
		int n = nums.length;
		int ans = 0;
		for (int i = 0; i < n; i++) {
			long lcm = nums[i];
			for (int j = i; j < n; j++) {
				lcm = lcm(lcm, nums[j]);
				if (lcm == k)
					ans++;
			}

		}
		return ans;
	}

	static long lcm(long a, long b) {
		return a * b / gcd(a, b);
	}

	static long gcd(long a, long b) {
		return a % b == 0 ? b : gcd(b, a % b);
	}
}
