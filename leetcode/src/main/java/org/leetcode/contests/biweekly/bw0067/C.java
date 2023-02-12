package org.leetcode.contests.biweekly.bw0067;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class C {
	public int maximumDetonation(int[][] bs) {
		int n = bs.length;
		int ans = 0;
		for (int i = 0; i < n; i++) {
			ans = Math.max(ans, solve(bs, i));
		}
		return ans;
	}

	static int solve(int[][] bs, int start) {
		int n = bs.length;
		DSU dsu = new DSU(n);
		Deque<Integer> dq = new ArrayDeque<>();
		dq.add(start);
		Deque<Integer> rem = new ArrayDeque<>();
		for (int i = 0; i < n; i++) {
			if (i != start)
				rem.add(i);
		}
		while (!dq.isEmpty()) {
			int cur = dq.poll();
			for (int i = 0, size = rem.size(); i < size; i++) {
				int nei = rem.poll();
				if (dist(bs[cur], bs[nei]) <= (long) bs[cur][2] * bs[cur][2]) {
					dsu.union(cur, nei);
					dq.add(nei);
				} else {
					rem.add(nei);
				}
			}
		}
		int ans = 0;
		for (int cand : dsu.sz) {
			ans = Math.max(ans, cand);
		}
		return ans;
	}

	static long dist(int[] a, int[] b) {
		return (long) (a[0] - b[0]) * (a[0] - b[0]) + (long) (a[1] - b[1]) * (a[1] - b[1]);
	}

	static class DSU {
		int[] id;
		int[] sz;
		int componentCount;

		public DSU(int n) {
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
