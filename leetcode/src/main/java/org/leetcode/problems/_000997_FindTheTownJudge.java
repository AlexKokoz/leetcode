package org.leetcode.problems;

/**
 * 
 * EASY
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000997_FindTheTownJudge {
	public int findJudge(int N, int[][] trust) {
		int[] indeg = new int[N];
		int[] outdeg = new int[N];
		for (int[] t : trust) {
			outdeg[t[0] - 1]++;
			indeg[t[1] - 1]++;
		}
		for (int i = 0; i < N; i++) {
			if (outdeg[i] == 0 && indeg[i] == N - 1)
				return i + 1;
		}
		return -1;
	}
}
