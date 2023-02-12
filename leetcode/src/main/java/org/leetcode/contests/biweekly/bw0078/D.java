package org.leetcode.contests.biweekly.bw0078;

/**
 * 
 * HARD
 * 
 * @author Alexandros Kokozidis
 *
 */
public class D {

	public int largestVariance(String s) {
		int n = s.length();
		int ans = 0;
		int[][] counts = new int[26][n + 1];
		for (int i = 0; i < n; i++) {
			int cur = s.charAt(i) - 'a';
			for (int ch = 0; ch < 26; ch++) {
				counts[ch][i + 1] += counts[ch][i];
			}
			counts[cur][i + 1]++;
		}

		for (char a = 'a'; a <= 'z'; a++) {
			for (char b = 'a'; b <= 'z'; b++) {
				if (a == b || counts[a - 'a'][n] == 0 || counts[b - 'a'][n] == 0)
					continue;
				int cand = go(s, a, b);
				ans = Math.max(ans, cand);

			}
		}
		return ans;
	}

	int go(String s, char a, char b) {
		int n = s.length();
		int ans = 0;
		boolean hasB = false;
		int as = 0;
		int bs = 0;
		int bal = 0;
		for (int i = 0; i < n;) {
			if (s.charAt(i) == a) {
				while (i < n && s.charAt(i) != b) {
					if (s.charAt(i) == a) {
						as++;
					}
					i++;
				}
				bal += as;
				ans = Math.max(ans, bal - (hasB ? 0 : 1));
				as = 0;
			} else if (s.charAt(i) == b) {
				while (i < n && s.charAt(i) != a) {
					if (s.charAt(i) == b) {
						bs++;
					}
					i++;
				}
				bal -= bs;
				if (bal >= 0) {
					hasB = true;
				} else {
					bal = 0;
					hasB = false;
				}
				bs = 0;
			} else {
				i++;
			}
		}
		return ans;
	}

}
