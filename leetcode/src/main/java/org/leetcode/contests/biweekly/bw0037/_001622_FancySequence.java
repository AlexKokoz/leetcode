package org.leetcode.contests.biweekly.bw0037;

import java.util.Arrays;

/**
 * 
 * HARD
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001622_FancySequence {
	class Fancy {
		final static long mod = 1_000_000_007;
		final static int MAX = 100000;
		long add;
		long mul;
		long[] nums;
		int p;

		public Fancy() {
			add = 0;
			mul = 1;
			nums = new long[MAX + 1];
		}

		public void append(int val) {
			long v = ((val - add) % mod + mod) % mod;
			v = (val * power(mul, mod - 2)) % mod;
			nums[p++] = v;
		}

		public void addAll(int inc) {
			add = (add + inc) % mod;
		}

		public void multAll(int m) {
			add = (add * m) % mod;
			mul = (mul * m) % mod;
		}

		public int getIndex(int idx) {
			System.out.println(Arrays.toString(nums) + " " + add + " " + mul);
			return idx >= p ? -1 : (int) ((nums[idx] * mul + add) % mod);
		}

		private long power(long n, long p) {
			long ans = 1;
			while (p > 0) {
				if ((p & 1) == 1)
					ans = (ans * n) % mod;
				n = (n * n) % mod;
				p >>= 1;
			}
			return ans;
		}
	}
}
