package org.leetcode.problems;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000718_MaximumLengthOfRepeatedSubarray {
	public int findLength(int[] A, int[] B) {
		int n = A.length;
		int[] dp = new int[n + 1];
		int max = 0;

		for (int i = 0; i < n; i++) {
			int[] ndp = new int[n + 1];
			for (int j = 0; j < n; j++)
				if (A[i] == B[j])
					ndp[j + 1] = 1 + dp[j];
			dp = ndp;
			for (int x : dp)
				max = Math.max(max, x);
		}
		return max;
	}
}
