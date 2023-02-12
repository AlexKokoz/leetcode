package org.leetcode.contests.weekly.w0220;

import java.util.Arrays;

/**
 * 
 * HARD
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001697_CheckingExistenceOfEdgeLengthLimitedPaths {
	public boolean[] distanceLimitedPathsExist(int n, int[][] edges, int[][] queries) {
		WeightedQuickUnion dsu = new WeightedQuickUnion(n);
		int en = edges.length;
		int qn = queries.length;
		boolean[] ans = new boolean[qn];
		Arrays.sort(edges, (a, b) -> Integer.compare(a[2], b[2]));
		for(int i = 0; i < qn; i++) {
			queries[i] = new int[] {queries[i][0], queries[i][1], queries[i][2], i};
		}
		Arrays.sort(queries, (a, b) -> Integer.compare(a[2], b[2]));
		int i = 0;
		for(int[] query : queries) {
			while(i < en && edges[i][2] < query[2]) {
				dsu.union(edges[i][0], edges[i][1]);
				i++;
			}
			ans[query[3]] = dsu.connected(query[0], query[1]);
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
