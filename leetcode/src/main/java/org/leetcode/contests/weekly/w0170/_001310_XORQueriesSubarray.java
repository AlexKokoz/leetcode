package org.leetcode.contests.weekly.w0170;

/**
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001310_XORQueriesSubarray {
	public int[] xorQueries(int[] a, int[][] q) {
		int[] pre  = new int[a.length];
		pre[0] = a[0];
		for (int i =1; i < a.length; i++)
			pre[i] = pre[i-1]^a[i];
		int[] ans = new int[q.length];
		for (int i = 0; i < q.length; i++) {
			int start = q[i][0];
			int end = q[i][1];
			ans[i] = pre[end]^(start == 0 ? 0 : pre[start - 1]);
		}
		return ans;
	}
}
