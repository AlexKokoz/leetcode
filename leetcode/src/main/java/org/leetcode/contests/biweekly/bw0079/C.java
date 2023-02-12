package org.leetcode.contests.biweekly.bw0079;

import java.util.Arrays;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class C {
	public long maximumImportance(int n, int[][] roads) {
		int[] indeg = new int[n];
		for (int[] road : roads) {
			indeg[road[0]]++;
			indeg[road[1]]++;
		}
		Arrays.sort(indeg);
		long ans = 0;
		for (int i = n - 1; i >= 0; i--) {
			ans += (long) (i + 1) * indeg[i];
		}
		return ans;
	}
}
