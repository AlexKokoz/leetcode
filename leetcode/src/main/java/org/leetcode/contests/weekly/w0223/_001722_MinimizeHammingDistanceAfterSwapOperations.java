package org.leetcode.contests.weekly.w0223;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001722_MinimizeHammingDistanceAfterSwapOperations {

	public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
		int n = source.length;
		WeightedQuickUnion dsu = new WeightedQuickUnion(n);
		int ans = n;
		for (int[] swap : allowedSwaps) {
			dsu.union(swap[0], swap[1]);
		}
		Map<Integer, MultiSet<Integer>> map = new HashMap<>();
		for (int i = 0; i < n; i++) {
			int p = dsu.find(i);
			map.computeIfAbsent(p, m -> new MultiSet<>()).add(source[i]);
		}

		for (int i = 0; i < n; i++) {
			MultiSet<Integer> multi = map.get(dsu.find(i));
			if (multi.contains(target[i])) {
				multi.remove(target[i]);
				ans--;
			}
		}

		return ans;
	}

	static boolean searchPair(MultiSet<Integer> min, MultiSet<Integer> max) {
		if (min == max) {
			for (int key : min) {
				if (min.count(key) > 1) {
					min.remove(key);
					min.remove(key);
					return true;
				}
			}
			return false;
		} else {
			for (int key : min) {
				if (max.contains(key)) {
					min.remove(key);
					max.remove(key);
					return true;
				}
			}
			return false;
		}
	}

	static class MultiSet<K> implements Iterable<K> {
		private final Map<K, Long> map;
		private long actualSize;

		public MultiSet() {
			this.map = new HashMap<>();
		}

		public boolean contains(final K key) {
			return map.containsKey(key);
		}

		public void add(final K key) {
			map.put(key, map.getOrDefault(key, 0L) + 1);
			actualSize++;
		}

		public Long count(final K key) {
			return map.get(key);
		}

		/**
		 * Removes one occurrence of the specified key, if it exists. If no more
		 * occurrences of this key remain right after the operation, the key is deleted
		 * from the multi-set.
		 * 
		 * @param key the specified key
		 * @return true if the specified key had at least one occurrence prior the
		 *         operation; false otherwise
		 */
		public boolean remove(final K key) {
			final Long count = map.get(key);

			// key doesn't exist in map
			if (count == null) {
				return false;
			}
			// key has only one occurrence
			else if (count == 1) {
				map.remove(key);
				actualSize--;
				return true;
			}
			// key had more than one occurrence
			else {
				map.put(key, count - 1);
				actualSize--;
				return true;
			}
		}

		/**
		 * Removes all occurrences of the key by effectively deleting the key
		 * 
		 * @param key the key
		 * @return true if the key existed; false otherwise
		 */
		public boolean removeAll(final K key) {
			final Long count = map.get(key);

			// key doesn't exist in map
			if (count == null) {
				return false;
			}
			// key exists
			else {
				actualSize -= count;
				map.remove(key);
				return true;
			}
		}

		public int size() {
			return map.size();
		}

		public long actualSize() {
			return actualSize;
		}

		@Override
		public Iterator<K> iterator() {
			return map.keySet().iterator();
		}

		@Override
		public String toString() {
			return map.toString();
		}

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
