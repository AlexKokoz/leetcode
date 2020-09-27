package org.leetcode.contests.weekly.w0208;

/**
 * 
 * HARD
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001601_MaximumNumberOfAchievableTransferRequests {
	int ans;

	public int maximumRequests(int n, int[][] requests) {
		int[] balance = new int[n];
		dfs(0, requests, balance, 0);
		return ans;
	}
	
	void dfs(int cur, int[][] requests, int[] balance, int achieved) {
		if (cur == requests.length) {
			for(int x : balance) {
				if (x != 0) return;
			}
			ans = Math.max(ans, achieved);
			return;
		}
		dfs(cur + 1, requests, balance, achieved); // no pick
		
		int from = requests[cur][0];
		int to = requests[cur][1];
		balance[from]--;
		balance[to]++;
		dfs(cur + 1, requests, balance, achieved + 1); // pick
		balance[from]++;
		balance[to]--;
	}
}
