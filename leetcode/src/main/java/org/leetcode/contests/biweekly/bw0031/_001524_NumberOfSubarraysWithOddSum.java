package org.leetcode.contests.biweekly.bw0031;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001524_NumberOfSubarraysWithOddSum {
	public int numOfSubarrays(int[] arr) {

		long mod = 1000000007;
		int n = arr.length;
		long[] evenodd = { 1, 0 };
		long ans = 0;
		int pref = 0;
		for (int i = 0; i < n; i++) {
			pref = (pref + arr[i]) % 2;
			evenodd[pref]++;
		}
		ans = (evenodd[0] * evenodd[1]) % mod;
		return (int) ans;
	}
}
