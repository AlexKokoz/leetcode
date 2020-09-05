package org.leetcode.problems;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 
 * HARD
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000952_LargestComponentSizeByCommonFactor {
	public int largestComponentSize(int[] A) {
		int max = Arrays.stream(A).parallel().max().getAsInt();
		WeightedQuickUnion dsu = new WeightedQuickUnion(max + 1);
		Set<Integer> set = new HashSet<>();
		for (int num : A)
			set.add(num);
		Integer v = null;
		for (int i = 2; i <= max / 2; i++) {
			v = null;
			for (int j = i; j <= max; j += i) {
				if (set.contains(j)) {
					if (v == null) {
						v = j;
					} else {
						dsu.union(v, j);
					}
				}
			}
		}
		int ans = Arrays.stream(dsu.sz).parallel().max().getAsInt();
		return ans;
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
