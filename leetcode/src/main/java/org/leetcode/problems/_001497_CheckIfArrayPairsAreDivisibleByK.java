package org.leetcode.problems;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001497_CheckIfArrayPairsAreDivisibleByK {
	public boolean canArrange(int[] arr, int k) {
		int[] freq = new int[k];
		for (int num : arr) {
			int rem = num % k;
			if (rem < 0)
				rem += k;
			freq[rem]++;
		}
		for (int num : arr) {
			int rem = num % k;
			if (rem < 0)
				rem += k;
			if (rem == 0 || 2 * rem == k) {
				if (freq[rem] % 2 == 1)
					return false;
			} else {
				if (freq[rem] != freq[k - rem]) {
					return false;
				}
			}
		}
		return true;
	}
}
