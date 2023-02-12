package org.leetcode.contests.weekly.w0267;

import java.util.Arrays;

/**
 * 
 * HARD
 * 
 * @author Alexandros Kokozidis
 *
 */
public class D {
	public boolean[] friendRequests(int n, int[][] restrictions, int[][] requests) {
		int nreq = requests.length;
		boolean[] ans = new boolean[nreq];
		DSU dsu = new DSU(n);
		for (int i = 0; i < nreq; i++) {
			int[] request = requests[i];
			int v = request[0], w = request[1];
			ans[i] = true;
			for (int[] restriction : restrictions) {
				int bv = restriction[0], bw = restriction[1];
				if ((dsu.connected(v, bv) && dsu.connected(w, bw))
						|| (dsu.connected(v, bw) && dsu.connected(w, bv))) {
					ans[i] = false;
					break;
				}
			}
			if (ans[i])
				dsu.union(v, w);

		}
		return ans;

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
