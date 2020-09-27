package org.leetcode.contests.weekly.w0206;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001584_MinCostToConnectAllPoints {
	public int minCostConnectPoints(int[][] points) {
		int n = points.length;
		int ans = 0;
		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i == j)
					continue;
				int dist = Math.abs(points[i][0] - points[j][0])
						+ Math.abs(points[i][1] - points[j][1]);
				pq.add(new int[] { i, j, dist });
			}
		}
		WeightedQuickUnion dsu = new WeightedQuickUnion(n);
		int counter = n - 1;
		while (counter > 0) {
			int[] cand = pq.poll();
			int a = cand[0];
			int b = cand[1];
			int dist = cand[2];
			if (dsu.connected(a, b))
				continue;
			dsu.union(a, b);
			ans += dist;
			counter--;
		}
		return ans;
	}

	class WeightedQuickUnion {
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
