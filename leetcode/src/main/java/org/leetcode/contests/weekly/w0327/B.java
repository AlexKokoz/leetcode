package org.leetcode.contests.weekly.w0327;

import java.util.Arrays;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class B {
	public int longestSquareStreak(int[] nums) {
		int max = 0;
		for (int num : nums)
			max = Math.max(max, num);
		DSU dsu = new DSU(max + 1);
		boolean[] exists = new boolean[max + 1];
		for (int num : nums)
			exists[num] = true;
		for (int num : nums) {
			int prev = (int) Math.sqrt(num);
			if (prev * prev == num && exists[prev]) {
				dsu.union(prev, num);
			}
			long next = (long) num * num;
			if (next <= max && exists[(int) next]) {
				dsu.union(num, (int) next);
			}
		}
		int ans = 0;
		for (int i = 0; i < dsu.sz.length; i++) {
			ans = Math.max(ans, dsu.sz[i]);
		}
		return ans >= 2 ? ans : -1;
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
