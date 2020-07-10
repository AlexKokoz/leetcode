package org.leetcode.problems;

import java.util.TreeSet;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000313_SuperUglyNumber {
	public int nthSuperUglyNumber(int n, int[] primes) {
		TreeSet<Long> set = new TreeSet<>();
		set.add(1L);
		long ans = 0;
		for (int i = 0; i < n; i++) {
			ans = set.pollFirst();
			for (int prime : primes) {
				set.add(ans * prime);
			}
		}
		return (int) ans;
	}
}
