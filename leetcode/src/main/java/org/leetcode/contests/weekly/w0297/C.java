package org.leetcode.contests.weekly.w0297;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class C {
	int ans = Integer.MAX_VALUE;	
	public int distributeCookies(int[] cookies, int k) {
		int[] kids = new int[k];
		dfs(0, cookies, k, kids);
		return ans;
	}
	
	void dfs(int i, int[] cookies, int k, int[] kids) {
		if (i == cookies.length) {
			int max = 0;
			for (int kid : kids) max = Math.max(max, kid);
			ans = Math.min(ans, max);
			return;
		}
		for (int j = 0; j < k; j++) {
			kids[j] += cookies[i];
			dfs(i + 1, cookies, k, kids);
			kids[j] -= cookies[i];
		}
	}
}
