package org.leetcode.contests.weekly.w0218;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001680_ConcatenationOfConsecutiveBinaryNumbers {
	public int concatenatedBinary(int n) {
		long ans = 0;
		long mod = 1000000007;
		long p2 = 1;
		for (int i = n; i >= 1; i--) {
			int num = i;
			while(num > 0) {
				if ((num & 1) == 1) {
					ans += p2;
					ans %= mod;
				}
				num >>= 1;
				p2 <<= 1;
				p2 %= mod;
			}
		}
		return (int) ans;
	}

}
