package org.leetcode.contests.biweekly.bw0075;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class C {
	public long numberOfWays(String s) {
		int n = s.length();
		int[][] lr = new int[2][n + 1];
		for (int i = 0; i < n; i++) {
			lr[s.charAt(i) - '0'][i + 1] = 1;
			lr[0][i + 1] += lr[0][i];
			lr[1][i + 1] += lr[1][i];
		}
		int[][] rl = new int[2][n + 1];
		for (int i = n - 1; i >= 0; i--) {
			rl[s.charAt(i) - '0'][i] = 1;
			rl[0][i] += rl[0][i + 1];
			rl[1][i] += rl[1][i + 1];
		}
		long ans = 0;
		for (int i = 0; i < n; i++) {
			ans += lr[1 - s.charAt(i) + '0'][i] * rl[1 - s.charAt(i) + '0'][i + 1];
		}
		return ans;
	}
}
