package org.leetcode.contests.weekly.w0281;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * HARD
 * 
 * @author Alexandros Kokozidis
 *
 */
public class D {
	public long countPairs(int[] nums, int k) {
		long ans = 0;
		List<long[]> factors = new ArrayList<>();
		for (int i = 1; i * i <= k; i++) {
			if (k % i == 0) {
				factors.add(new long[] { i, 0 });
				if (k / i != i) {
					factors.add(new long[] { k / i, 0 });
				}
			}
		}
		for (int num : nums) {
			int gcd = gcd(num, k);
			for (long[] factor : factors) {
				if (((long) gcd * factor[0]) % k == 0) {
					ans += factor[1];
				}
				if (gcd == factor[0])
					factor[1]++;
			}
		}
		return ans;
	}

	int gcd(int a, int b) {
		while (b > 0) {
			int c = a;
			a = b;
			b = c % b;
		}
		return a;
	}
}
