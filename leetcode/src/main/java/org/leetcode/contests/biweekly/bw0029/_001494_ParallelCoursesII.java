package org.leetcode.contests.biweekly.bw0029;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 
 * HARD
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001494_ParallelCoursesII {

	public int minNumberOfSemesters(int n, int[][] dependencies, int k) {
		int p = dependencies.length;
		int[] from = new int[p];
		int[] to = new int[p];
		for (int i = 0; i < p; i++) {
			int[] d = dependencies[i];
			from[i] = d[0] - 1;
			to[i] = d[1] - 1;
		}
		int[][] adj = packD(n, from, to);

		int[] in = new int[n];
		for (int x : to)
			in[x]++;

		boolean[] ok = new boolean[n];
		for (int i = 0; i < n; i++) {
			if (in[i] == 0)
				ok[i] = true;
		}
		boolean[] taken = new boolean[n];

		int nTaken = 0;
		int ans = 0;
		while (nTaken < n) {
			int[][] ai = new int[n][2];
			for (int i = 0; i < n; i++) {
				ai[i][0] = i;
				ai[i][1] = taken[i] ? Integer.MAX_VALUE : adj[i].length;
			}
			Arrays.sort(ai, new Comparator<int[]>() {
				public int compare(int[] a, int[] b) {
					int x = a[1] == 0 ? Integer.MAX_VALUE / 2 : a[1];
					int y = b[1] == 0 ? Integer.MAX_VALUE / 2 : b[1];
					return x < y ? -1 : x > y ? 1 : 0;
				}
			});

			ans++;
			int kk = k;
			Queue<Integer> q = new LinkedList<>();
			for (int j = 0; j < n; j++) {
				if (kk == 0)
					break;
				int i = ai[j][0];
				if (ai[j][1] == Integer.MAX_VALUE)
					break;
				if (ok[i]) {

					taken[i] = true;
					kk--;
					nTaken++;
					q.add(i);

				}
			}
			for (int v : q) {
				for (int w : adj[v]) {
					in[w]--;
					if (in[w] == 0)
						ok[w] = true;
				}
			}
		}
		return ans;
	}

	int[][] packD(int n, int[] from, int[] to) {
		int[] out = new int[n];
		for (int i = 0; i < from.length; i++)
			out[from[i]]++;
		int[][] ret = new int[n][];
		for (int i = 0; i < ret.length; i++)
			ret[i] = new int[out[i]];
		for (int i = 0; i < from.length; i++)
			ret[from[i]][--out[from[i]]] = to[i];
		return ret;
	}
}
