package org.leetcode.contests.weekly.w0278;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * HARD
 * 
 * @author Alexandros Kokozidis
 *
 */
public class D {
	public int[] groupStrings(String[] words) {
		int n = words.length;
		DSU dsu = new DSU(n);
		Map<Integer, Integer> map = new HashMap<>();
		int[] masks = new int[n];
		// Arrays.sort(words, (a, b) -> Integer.compare(b.length(), a.length()));
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < words[i].length(); j++) {
				masks[i] |= 1 << (words[i].charAt(j) - 'a');
			}
		}
		for (int i = 0; i < n; i++) {
			for (int b = 0; b < 26; b++) {
				// has letter b
				if (masks[i] << ~b < 0) {
					// deleting
					int deleted = masks[i] & ~(1 << b);
					if (map.containsKey(deleted)) {
						dsu.union(i, map.get(deleted));
					}
					// replace
					for (int bb = 0; bb < 26; bb++) {
						int replaced = (masks[i] & ~(1 << b)) | (1 << bb);
						if (map.containsKey(replaced)) {
							dsu.union(i, map.get(replaced));
						}
					}
				}
				// hasn't letter b
				else {
					// add
					int added = masks[i] | (1 << b);
					if (map.containsKey(added)) {
						dsu.union(i, map.get(added));
					}
				}
			}
			map.put(masks[i], i);
		}
		int[] ans = new int[2];
		ans[0] = dsu.componentCount();
		for (int cand : dsu.sz) {
			ans[1] = Math.max(ans[1], cand);
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
