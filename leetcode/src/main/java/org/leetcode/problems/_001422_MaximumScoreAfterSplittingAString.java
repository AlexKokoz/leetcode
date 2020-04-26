package org.leetcode.problems;

/**
 * 
 * EASY
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001422_MaximumScoreAfterSplittingAString {
	public int maxScore(String s) {
		int n = s.length();
		
		int[] zeros = new int[n];
		zeros[0] = s.charAt(0) == '0' ? 1 : 0;
		for (int i = 1; i < n; i++)
			zeros[i] = zeros[i - 1] + (s.charAt(i) == '0' ? 1 : 0);
		
		int[] ones = new int[n];
		ones[n - 1] = s.charAt(n - 1) == '1' ? 1 : 0;
		for (int i = n - 2; i >= 0; i--)
			ones[i] = ones[i + 1] + (s.charAt(i) == '1' ? 1 : 0);
		
		int ans = Integer.MIN_VALUE;
		for (int i = 0; i < n - 1; i++)
			ans = Math.max(ans, zeros[i] + ones[i + 1]);
		return ans;
	}
}
