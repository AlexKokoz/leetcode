package org.leetcode.problems;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001267_CountServersThatCommunicate {

	public int countServers(int[][] g) {
		int n = g.length;
		int m = g[0].length;
		int[] rowCounts = new int[n];
		int[] colCounts = new int[m];
		for (int r = 0; r < n; r++)
			for (int c = 0; c < m; c++)
				if (g[r][c] == 1) {
					rowCounts[r]++;
					colCounts[c]++;
				}
		int count = 0;
		for (int r = 0; r < n; r++)
			for (int c = 0; c < m; c++)
				if (g[r][c] == 1 && rowCounts[r] > 1 && colCounts[c] > 1)
					count++;
		return count;
	}
}
