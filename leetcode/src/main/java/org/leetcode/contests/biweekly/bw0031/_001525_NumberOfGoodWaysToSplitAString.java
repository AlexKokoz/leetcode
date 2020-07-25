package org.leetcode.contests.biweekly.bw0031;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001525_NumberOfGoodWaysToSplitAString {
	public int numSplits(String s) {
		int n = s.length();
		int[][] cum = new int[26][n + 1];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < cum.length; j++)
				cum[j][i + 1] = cum[j][i];
			int c = s.charAt(i) - 'a';
			cum[c][i + 1] = cum[c][i] + 1;
		}
		int ans = 0;
		for (int i = 0; i < n - 1; i++) {
			int left = query(cum, i, true);
			int right = query(cum, i + 1, false);
			if (left == right)
				ans++;
		}
		return ans;
	}

	static int query(int[][] cum, int from, boolean left) {
		int ret = 0;
		if (left) {
			for (int i = 0; i < 26; i++) {
				ret += (cum[i][from + 1] > 0) ? 1 : 0;
			}
		} else {
			for (int i = 0; i < 26; i++) {
				ret += (cum[i][cum[0].length - 1] - cum[i][from] > 0) ? 1 : 0;
			}
		}
		return ret;
	}
}
