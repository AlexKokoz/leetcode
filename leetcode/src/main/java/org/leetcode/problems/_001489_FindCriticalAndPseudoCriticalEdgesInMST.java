package org.leetcode.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 
 * HARD
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001489_FindCriticalAndPseudoCriticalEdgesInMST {
	public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {
		int p = edges.length;
		int[][] sorted = new int[p][];
		for (int i = 0; i < p; i++)
			sorted[i] = Arrays.copyOf(edges[i], 3);
		Arrays.sort(sorted, new Comparator<int[]>() {
			public int compare(int[] a, int[] b) {
				return a[2] - b[2];
			}
		});

		int mstCost = mstCost(n, sorted, null, null);
		System.out.println(mstCost);

		// find critical edges
		List<Integer> critical = new ArrayList<>();
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < edges.length; i++) {
			int[] edge = edges[i];
			int newCost = mstCost(n, sorted, edge, null);
			if (newCost > mstCost) {
				critical.add(i);
				set.add(i);
			}
		}

		// find pseudo-critical edges
		List<Integer> pseudo = new ArrayList<>();
		for (int i = 0; i < edges.length; i++) {
			if (set.contains(i))
				continue;
			int[] edge = edges[i];

			int newCost = mstCost(n, sorted, null, edge);
			if (newCost == mstCost)
				pseudo.add(i);
		}

		return Arrays.asList(critical, pseudo);
	}

	static int mstCost(int n, int[][] sortedEdges, int[] excluded, int[] picked) {
		if (excluded != null && picked != null && excluded[0] == picked[0] && excluded[1] == picked[1]
				&& excluded[2] == picked[2]) {
			excluded = null;
			picked = null;
		}
		WeightedQuickUnion qu = new WeightedQuickUnion(n);
		int cost = 0;

		if (picked != null) {
			qu.union(picked[0], picked[1]);
			cost += picked[2];
		}
		for (int[] e : sortedEdges) {
			if (qu.componentCount() == 1)
				break;
			int from = e[0];
			int to = e[1];
			int w = e[2];
			if (excluded != null && from == excluded[0] && to == excluded[1] && w == excluded[2])
				continue;
			if (qu.connected(from, to))
				continue;
			qu.union(from, to);
			cost += w;
		}

		return (qu.componentCount() == 1) ? cost : Integer.MAX_VALUE;
	}

	static class WeightedQuickUnion {
		int[] id;
		int[] sz;
		int componentCount;

		public WeightedQuickUnion(int n) {
			id = new int[n];
			for (int i = 0; i < n; i++)
				id[i] = i;
			sz = new int[n];
			Arrays.fill(sz, 1);
			componentCount = n;
		}

		public int componentCount() {
			return componentCount;
		}

		public int find(int v) {
			validate(v);
			while (v != id[v]) {
				id[v] = id[id[v]];
				v = id[v];
			}
			return v;
		}

		public boolean connected(int v, int w) {
			validate(v);
			validate(w);
			int p = find(v);
			int q = find(w);
			return p == q;
		}

		public void union(int v, int w) {
			validate(v);
			validate(w);
			int p = find(v);
			int q = find(w);
			if (p == q)
				return;
			if (sz[p] >= sz[q]) {
				id[q] = p;
				sz[p] += sz[q];
			} else {
				id[p] = q;
				sz[q] += sz[p];
			}
			componentCount--;
		}

		private void validate(int v) {
			if (v < 0 || v >= id.length) {
				throw new IllegalArgumentException("v should be between 0 and " + (id.length - 1));
			}
		}
	}
}
