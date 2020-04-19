package org.leetcode.contests.biweekly.bw0024;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001415_TheKthLexicographicalStringOfAllHappyStringsOfLengthN {
	public String getHappyString(int n, int k) {
		int[] count = new int[1];
		count[0] = k;
		String[] ans = new String[1];
		ans[0] = "";
		dfs(new StringBuilder(), count, ans, n);
		return ans[0];
	}

	void dfs(StringBuilder sb, int[] count, String[] ans, int n) {
		if (count[0] == 0)
			return;
		if (sb.length() == n) {
			count[0]--;
			if (count[0] == 0)
				ans[0] = sb.toString();
			return;
		}
		for (int c = 'a'; c <= 'c'; c++) {
			if (sb.length() > 0 && sb.charAt(sb.length() - 1) == c)
				continue;
			sb.append((char) c);
			dfs(sb, count, ans, n);
			sb.deleteCharAt(sb.length() - 1);
		}
	}
}
