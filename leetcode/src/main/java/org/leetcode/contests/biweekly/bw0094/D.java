package org.leetcode.contests.biweekly.bw0094;

/**
 * 
 * HARD
 * 
 * @author Alexandros Kokozidis
 *
 */
public class D {
	public int countAnagrams(String s) {
		s = s.trim();
		if (s.length() == 0)
			return 0;
		long ans = 1;
		long mod = 1000000007;

		long[] fac = new long[s.length() + 1];
		fac[0] = 1;
		for (int i = 1; i < fac.length; i++) {
			fac[i] = i * fac[i - 1];
			fac[i] %= mod;
		}
		
		long[] ifac = new long[fac.length];
		for (int i = 1; i < ifac.length; i++) {
			ifac[i] = invl(fac[i], mod);
		}

		for (String w : s.split(" ")) {
			int[] counter = new int[26];
			for (int i = 0; i < w.length(); i++) {
				counter[w.charAt(i) - 'a']++;
			}
			long ways = fac[w.length()];
			for (int i = 0; i < counter.length; i++) {
				if (counter[i] > 0) {
					ways *= ifac[counter[i]];
					ways %= mod;
				}
			}
			ans *= ways;
			ans %= mod;
		}
		return (int)ans;
	}
	
	long invl(long a, long mod) {
		long b = mod;
		long p = 1, q = 0;
		while (b > 0) {
			long c = a / b;
			long d;
			d = a;
			a = b;
			b = d % b;
			d = p;
			p = q;
			q = d - c * q;
		}
		return p < 0 ? p + mod : p;
	}
}
