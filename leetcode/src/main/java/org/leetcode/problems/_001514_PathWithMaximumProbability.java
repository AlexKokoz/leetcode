package org.leetcode.problems;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001514_PathWithMaximumProbability {

	public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
		int[] from = new int[edges.length];
		int[] to = new int[edges.length];
		int[] w = new int[edges.length];

		for (int i = 0; i < edges.length; i++) {
			from[i] = edges[i][0];
			to[i] = edges[i][1];
			w[i] = i;
		}
		int[][][] adj = packWU(n, from, to, w);

		double[] best = new double[n];
		Queue<double[]> q = new LinkedList<>();
		q.add(new double[] {start, 1});
		
		while(!q.isEmpty()) {
			double[] cur = q.poll();
			int src = (int) cur[0];
			double prob = cur[1];
			for (int[] next : adj[src]) {
				int dest = (int) next[0];
				double destProb = succProb[next[1]];
				double candProb = prob * destProb;
				if (dest == src || best[dest] >= candProb) continue;
				best[dest] = candProb;
				q.add(new double[] {dest, candProb});
			}
		}
		return best[end];
	}

	static int[][][] packWU(int n, int[] from, int[] to, int[] w) {
		int[] out = new int[n];
		for (int i = 0; i < from.length; i++) {
			out[to[i]]++;
			out[from[i]]++;
		}
		int[][][] ret = new int[n][][];
		for (int i = 0; i < ret.length; i++)
			ret[i] = new int[out[i]][];
		for (int i = 0; i < from.length; i++) {
			ret[from[i]][--out[from[i]]] = new int[] { to[i], w[i] };
			ret[to[i]][--out[to[i]]] = new int[] { from[i], w[i] };
		}
		return ret;
	}
}
