package org.leetcode.contests.weekly.w0213;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001641_CountSortedVowelStrings {
	int ans = 0;
	int n;

	public int countVowelStrings(int n) {
		this.n = n;
		for (int i = 1; i <= 5; i++)
			dfs(i, 1);
		return ans;
	}

	void dfs(int prev, int len) {
		if (len == n) {
			ans++;
			return;
		}
		dfs(prev, len + 1);
		for (int i = prev + 1; i <= 5; i++)
			dfs(i, len + 1);
	}
}
