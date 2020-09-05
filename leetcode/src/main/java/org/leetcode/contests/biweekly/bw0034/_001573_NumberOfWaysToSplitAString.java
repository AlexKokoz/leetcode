package org.leetcode.contests.biweekly.bw0034;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001573_NumberOfWaysToSplitAString {
	public int numWays(String s) {
		int n = s.length();
		long mod = 1000000007;
		int ones = 0;
		for (int i = 0; i < n; i++)
			ones += s.charAt(i) - '0';
		if (ones % 3 != 0)
			return 0;
		if (ones == 0) {
			return (int) choose2(n - 1, mod);
		}

		long athird = ones / 3;
		long zeroes1 = 0;
		long zeroes2 = 0;
		int i = 0;
		for (int count = 0; i < n && count < athird; i++)
			count += s.charAt(i) - '0';
		for (; i < n && s.charAt(i) != '1'; i++)
			zeroes1++;
		for (int count = 0; i < n && count < athird; i++)
			count += s.charAt(i) - '0';
		for (; i < n && s.charAt(i) != '1'; i++)
			zeroes2++;
		long ans = (zeroes1 + 1) * (zeroes2 + 1);
		return (int) (ans % mod);
	}

	long choose2(long n, long mod) {
		long k = n - 2;
		long res = 1;
		for (long i = 0; i < k; i++) {
			res *= (3 + i);
			res /= i + 1;
		}
		return res % mod;
	}
}
