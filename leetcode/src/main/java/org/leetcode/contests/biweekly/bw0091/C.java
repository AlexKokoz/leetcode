package org.leetcode.contests.biweekly.bw0091;

import java.util.Arrays;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class C {
	int ans = Integer.MIN_VALUE;

	public int mostProfitablePath(int[][] edges, int bob, int[] amount) {
		int n = amount.length;
		int[] from = new int[n - 1];
		int[] to = new int[n - 1];
		for (int i = 0; i < n - 1; i++) {
			from[i] = edges[i][0];
			to[i] = edges[i][1];
		}
		int[][] adj = packU(n, from, to);
		int[] bobArrives = new int[n];
		Arrays.fill(bobArrives, Integer.MAX_VALUE / 2);
		dfsBob(-1, bob, bobArrives, adj, 0);
		dfsAlice(-1, 0, adj, bobArrives, 0, 0, amount);
		return ans;
	}

	void dfsAlice(int p, int ch, int[][] adj, int[] bobArrives, int step, int cand, int[] amount) {
		if (step < bobArrives[ch]) {
			cand += amount[ch];
		} else if (step == bobArrives[ch]) {
			cand += amount[ch] / 2;
		}
		if ((ch != 0 && adj[ch].length == 1) || (ch == 0 && adj[0].length == 0)) {
			ans = Math.max(ans, cand);
		}
		for (int nch : adj[ch]) {
			if (nch == p)
				continue;
			dfsAlice(ch, nch, adj, bobArrives, step + 1, cand, amount);
		}
	}

	boolean dfsBob(int p, int ch, int[] bobArrives, int[][] adj, int step) {
		if (ch == 0) {
			bobArrives[ch] = step;
			return true;
		}
		boolean ret = false;
		for (int nch : adj[ch]) {
			if (nch == p)
				continue;
			ret |= dfsBob(ch, nch, bobArrives, adj, step + 1);
		}
		if (ret) {
			bobArrives[ch] = step;
		}
		return ret;
	}

	int[][] packU(int n, int[] from, int[] to) {
		int[] out = new int[n];
		for (int i = 0; i < from.length; i++) {
			out[to[i]]++;
			out[from[i]]++;
		}
		int[][] ret = new int[n][];
		for (int i = 0; i < ret.length; i++)
			ret[i] = new int[out[i]];
		for (int i = 0; i < from.length; i++) {
			ret[from[i]][--out[from[i]]] = to[i];
			ret[to[i]][--out[to[i]]] = from[i];
		}
		return ret;
	}
}
