package org.leetcode.contests.biweekly.bw0092;

/**
 * 
 * HARD
 * 
 * @author Alexandros Kokozidis
 *
 */
public class D {
	public int countPalindromes(String s) {
		int n = s.length();
		long ans = 0;
		long mod = 1000000007;

		int[] countLR = new int[10];
		long[][][] dpLR = new long[n + 1][10][10];
		for (int i = 0; i < n; i++) {
			int cur = s.charAt(i) - '0';
			for (int j = 0; j < 10; j++) {
				for (int k = 0; k < 10; k++) {
					dpLR[i + 1][j][k] += dpLR[i][j][k];
					if (dpLR[i + 1][j][k] >= mod)
						dpLR[i + 1][j][k] -= mod;
				}
			}
			if (i >= 1) {
				for (int pre = 0; pre < 10; pre++) {
					dpLR[i + 1][pre][cur] += countLR[pre];
					if (dpLR[i + 1][pre][cur] >= mod)
						dpLR[i + 1][pre][cur] -= mod;
				}
			}
			countLR[cur]++;
		}

		int[] countRL = new int[10];
		long[][][] dpRL = new long[n + 1][10][10];
		for (int i = n - 1; i >= 0; i--) {
			int cur = s.charAt(i) - '0';
			for (int j = 0; j < 10; j++) {
				for (int k = 0; k < 10; k++) {
					dpRL[i][j][k] += dpRL[i + 1][j][k];
					if (dpRL[i][j][k] >= mod)
						dpRL[i][j][k] -= mod;
				}
			}
			if (i < n - 1) {
				for (int nxt = 0; nxt < 10; nxt++) {

					dpRL[i][cur][nxt] += countRL[nxt];
					if (dpRL[i][cur][nxt] >= mod)
						dpRL[i][cur][nxt] -= mod;
				}
			}
			countRL[cur]++;
		}
		for (int i = 2; i + 2 <= n; i++) {
			for (int j = 0; j < 10; j++) {
				for (int k = 0; k < 10; k++) {
					ans += dpLR[i][j][k] * dpRL[i + 1][k][j];
					ans %= mod;
				}
			}
		}
		return (int) ans;

	}
}
