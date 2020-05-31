package org.leetcode.problems;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001035_UncrossedLines {
	public int maxUncrossedLines(int[] A, int[] B) {
		int na = A.length;
		int nb = B.length;
		int[] dp = new int[nb + 1];
		for (int r = 0; r < na; r++) {
			int[] ndp = new int[dp.length];
			for (int c = 0; c < nb; c++) {
				if (A[r] == B[c]) {
					ndp[c + 1] = dp[c] + 1;
				} else {
					ndp[c + 1] = Math.max(ndp[c], dp[c + 1]);
				}
			}
			dp = ndp;
		}
		return dp[nb];
	}
}
