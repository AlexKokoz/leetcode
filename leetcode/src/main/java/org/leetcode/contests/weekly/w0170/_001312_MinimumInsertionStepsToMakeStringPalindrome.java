package org.leetcode.contests.weekly.w0170;

/**
 * HARD
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001312_MinimumInsertionStepsToMakeStringPalindrome {
	String s;
	Integer[][] dp;

	public int minInsertions(String s) {
		this.s = s;
		this.dp = new Integer[s.length()][s.length()];
		return dp(0, s.length() - 1);
	}

	int dp(int lo, int hi) {
		if (dp[lo][hi] != null)
			return dp[lo][hi];
		int ans = 0;
		if (lo == hi) // same letter; it's a palindrome in itself
			ans = 0;
		else if (lo == hi - 1) // adjacent positioned letters; one insertion needed if they differ 
			ans = (s.charAt(lo) == s.charAt(hi) ? 0 : 1);
		else if (s.charAt(lo) == s.charAt(hi)) // same letter in both edges; recurse for the enclosed string
			ans = dp(lo + 1, hi - 1);
		else // one insertion + the minimum from the string without the first letter or without the last letter
			ans = 1 + Math.min(dp(lo + 1, hi), dp(lo, hi - 1));
		dp[lo][hi] = ans;
		return dp[lo][hi];
	}
}
