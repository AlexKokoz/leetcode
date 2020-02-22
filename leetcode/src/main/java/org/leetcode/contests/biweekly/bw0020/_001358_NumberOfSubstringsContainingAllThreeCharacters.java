package org.leetcode.contests.biweekly.bw0020;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001358_NumberOfSubstringsContainingAllThreeCharacters {
	public int numberOfSubstrings(String s) {
		int n = s.length();
		int[][] pre = new int[3][n + 1];
		for (int i = 0; i < n; i++) {
			pre[s.charAt(i) - 'a'][i + 1]++;
		}
		for (int j = 0; j < 3; j++) {
			for (int i = 1; i <= n; i++) {
				pre[j][i] += pre[j][i - 1];
			}
		}

		int count = 0;
		int l = 0;
		int r = Math.min(n - 1, 2);
		int last = 0;
		while (r < n) {
			if (containsAll(pre, l, r)) {
				while (containsAll(pre, l + 1, r))
					l++;
				System.out.println(l + " " + r);
				int leftPart = l - last;
				int rightPart = n - 1 - r;
				count += 1 + leftPart + rightPart + leftPart * rightPart;
				l++;
				last = l;
			} else {
				r++;
			}
		}
		return count;

	}

	boolean containsAll(int[][] pre, int l, int r) {
		if (pre[0][r + 1] - pre[0][l] > 0 && pre[1][r + 1] - pre[1][l] > 0 && pre[2][r + 1] - pre[2][l] > 0) {
			return true;
		}
		return false;
	}
}
