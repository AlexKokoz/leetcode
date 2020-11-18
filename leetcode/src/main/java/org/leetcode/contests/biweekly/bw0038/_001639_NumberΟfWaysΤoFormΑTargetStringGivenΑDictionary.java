package org.leetcode.contests.biweekly.bw0038;

/**
 * 
 * HARD
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001639_NumberΟfWaysΤoFormΑTargetStringGivenΑDictionary {
	public int numWays(String[] words, String target) {
		int nt = target.length();
		int n = words[0].length();
		int[][] f = new int[26][n];
		long m = 1000000007;
		for (String w : words) {
			for (int j = 0; j < n; j++) {
				int c = w.charAt(j) - 'a';
				f[c][j]++;
			}
		}

		long[] dp = new long[n];
		for (int i = 0; i < n; i++)
			dp[i] = f[target.charAt(0) - 'a'][i];

		for (int i = 1; i < nt; i++) {
			long[] ndp = new long[dp.length];
			int curr = target.charAt(i) - 'a';
			long count = 0;
			for (int j = 0; j < ndp.length; j++) {
				ndp[j] = count * f[curr][j] % m;
				count = (count + dp[j]) % m;
			}
			dp = ndp;
		}
		long ans = 0;
		for (long x : dp)
			ans = (ans + x) % m;
		return (int) ans;

	}

}
