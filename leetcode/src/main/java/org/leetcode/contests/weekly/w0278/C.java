package org.leetcode.contests.weekly.w0278;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class C {
	// inverse Rabin-Karp
	// hash function = s[0] * p ^ (k - 1) + ... + s[k - 1] * p ^ 0
	public String subStrHash(String s, int power, int modulo, int k, int hashValue) {
		int n = s.length();
		int start = n;
		long hash = 0;
		long pk1 = 1;
		for (int i = 1; i <= k - 1; i++) {
			pk1 = (pk1 * power) % modulo;
		}
		for (int i = n - 1; i >= 0; i--) {
			// adding new leftmost
			hash = (hash * power + (s.charAt(i) - 'a' + 1)) % modulo; 
			if (i + k <= n) {
				if (hash == hashValue) {
					start = i;
				}
				// removing rightmost
				hash = (hash - ((s.charAt(i + k - 1) - 'a' + 1) * pk1) % modulo + modulo) % modulo;
			}
		}

		return s.substring(start, start + k);
	}

}
