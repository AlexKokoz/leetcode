package org.leetcode.contests.weekly.w0213;

/**
 * 
 * HARD
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001642_KthSmallestInstructions {

	public String kthSmallestPath(int[] destination, int k) {
		int[][] choose = choose(30, 30);

		StringBuilder sb = new StringBuilder();
		int remSteps = destination[0] + destination[1] - 1;
		int remRows = destination[0];

		for (int i = 0; i < destination[0] + destination[1]; i++) {
			int total = choose[remSteps][remRows];
			if (total >= k) {
				sb.append("H");
			} else {
				sb.append("V");
				k -= total;
				remRows--;
			}
			remSteps--;
		}
		return sb.toString();
	}

	// n choose x [Pascal's triangle]
	int[][] choose(int n, int x) {
		int[][] choose = new int[n + 1][x + 1];
		for (int r = 0; r < choose.length; r++) {
			choose[r][0] = 1;
			for (int c = 1; c <= r; c++)
				choose[r][c] = choose[r - 1][c - 1] + choose[r - 1][c];
		}
		return choose;
	}

}
