package org.leetcode.contests.weekly.w0284;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Objects;

/**
 * 
 * HARD
 * 
 * @author Alexandros Kokozidis
 *
 */
public class D {
	public long minimumWeight(int n, int[][] edges, int src1, int src2, int dest) {
		int m = edges.length;
		int[] from = new int[m];
		int[] to = new int[m];
		int[] ws = new int[m];
		for (int i = 0; i < m; i++) {
			from[i] = edges[i][0];
			to[i] = edges[i][1];
			ws[i] = edges[i][2];
		}
		int[][][] adj = packWD(n, from, to, ws);
		long[] dist1 = shortestPathsDirectedNonNegativeDijkstra(adj, src1);
		long[] dist2 = shortestPathsDirectedNonNegativeDijkstra(adj, src2);
		long[] dist3 = shortestPathsDirectedNonNegativeDijkstra(packWD(n, to, from, ws), dest);
		long ans = Long.MAX_VALUE;
		for (int i = 0; i < n; i++) {
			if (dist1[i] != Long.MAX_VALUE && dist2[i] != Long.MAX_VALUE && dist3[i] != Long.MAX_VALUE) {
				ans = Math.min(ans, dist1[i] + dist2[i] + dist3[i]);
			}
		}
		if (ans == Long.MAX_VALUE)
			ans = -1;
		return ans;
	}
	


	static int[][][] packWD(int n, int[] from, int[] to, int[] w) {
		int[] out = new int[n];
		for (int i = 0; i < from.length; i++)
			out[from[i]]++;
		int[][][] ret = new int[n][][];
		for (int i = 0; i < ret.length; i++)
			ret[i] = new int[out[i]][];
		for (int i = 0; i < from.length; i++)
			ret[from[i]][--out[from[i]]] = new int[] { to[i], w[i] };
		return ret;
	}
	
	static long[] shortestPathsDirectedNonNegativeDijkstra(int[][][] adj, int src) {
		int n = adj.length;
		long[] dist = new long[n];
		MinHeap<Long> heap = new MinHeap<>(n);
		heap.add(src, 0L);
		Arrays.fill(dist, Long.MAX_VALUE);
		dist[src] = 0;

		while (!heap.isEmpty()) {
			int cur = heap.poll();
			for (int[] e : adj[cur]) {
				long cand = dist[cur] + e[1];
				if (cand < dist[e[0]]) {
					dist[e[0]] = cand;
					heap.add(e[0], cand);
				}
			}
		}
		return dist;
	}

	static class MinHeap<Key> implements Iterable<Integer> {

		private final Object[] keys;
		private final Comparator<? super Key> comparator;
		private final int[] pq;
		private final int[] qp;
		private int size;

		public MinHeap(final int initialCapacity, final Comparator<? super Key> comparator) {
			if (initialCapacity < 1)
				throw new IllegalArgumentException();
			this.comparator = comparator;
			this.keys = new Object[initialCapacity];
			this.pq = new int[initialCapacity];
			this.qp = new int[initialCapacity];
			Arrays.fill(qp, -1);
		}

		public MinHeap(final int initialCapacity) {
			this(initialCapacity, null);
		}

		public int capacity() {
			return this.keys.length;
		}

		public int size() {
			return this.size;
		}

		public boolean isEmpty() {
			return this.size() == 0;
		}

		public boolean contains(final int index) {
			Objects.checkIndex(index, this.capacity());
			return this.qp[index] != -1;
		}

		public void add(final int index, final Key key) {
			Objects.checkIndex(index, this.capacity());
			Objects.nonNull(key);
			if (this.contains(index)) {
				this.update(index, key);
			} else {
				this.keys[index] = key;
				this.pq[this.size()] = index;
				this.qp[index] = this.size();
				this.size++;
				this.swim(this.qp[index]);
			}
		}

		public int poll() {
			if (this.isEmpty())
				throw new IllegalArgumentException("Heap is empty");
			int index = this.pq[0];
			this.swap(0, this.size() - 1);
			this.qp[index] = -1;
			this.size--;
			if (!this.isEmpty())
				sink(0);
			return index;
		}

		public Key keyOf(final int index) {
			Objects.checkIndex(index, this.capacity());
			final Key key = (Key) this.keys[index];
			return key;
		}

		public int peek() {
			if (this.isEmpty())
				throw new IllegalArgumentException("heap is empty");
			return this.pq[0];
		}

		public void update(final int index, final Key key) {
			Objects.checkIndex(index, this.capacity());
			Objects.nonNull(key);
			if (this.contains(index)) {
				this.keys[index] = key;
				this.swim(this.qp[index]);
				this.sink(this.qp[index]);
			} else {
				this.add(index, key);
			}
		}

		public Key remove(final int index) {
			return removeAt(index);
		}

		public Comparator<? super Key> comparator() {
			return this.comparator;
		}

		/**********************************************************************
		 * Heap helper functions
		 **********************************************************************/

		private void sink(int curPos) {
			Objects.checkIndex(curPos, this.size());
			Object curKey = this.keyOf(this.pq[curPos]);
			while (true) {
				int childPos = curPos * 2 + 1; // assume left child is least
				int rightChildPos = childPos + 1;
				if (childPos < this.size()) {
					Object childKey = this.keyOf(this.pq[childPos]);
					if (rightChildPos < this.size()) {
						Object rightChildKey = this.keyOf(this.pq[rightChildPos]);
						if (less(rightChildKey, childKey)) {
							childPos = rightChildPos;
							childKey = this.keyOf(this.pq[childPos]);
						}
					}
					if (less(childKey, curKey)) {
						swap(childPos, curPos);
						curPos = childPos;
						continue;
					}
				}
				break;
			}
		}

		private void swim(int curPos) {
			Objects.checkIndex(curPos, this.size());
			while (true) {
				int parentPos = (curPos - 1) / 2;
				final Object curObject = this.keys[this.pq[curPos]];
				final Object parentObject = this.keys[this.pq[parentPos]];
				if (this.less(curObject, parentObject)) {
					this.swap(curPos, parentPos);
					curPos = parentPos;
					continue;
				}
				break;
			}
		}

		private Key removeAt(final int index) {
			Objects.checkIndex(index, this.capacity());
			if (this.qp[index] == -1)
				return null;
			final Key removed = this.keyOf(index);
			final int pos = this.qp[index];
			this.swap(pos, this.size() - 1);
			final int movedIndex = this.pq[pos];
			this.qp[index] = -1;
			this.size--;
			if (!this.isEmpty()) {
				sink(pos);
				if (this.pq[pos] == movedIndex)
					swim(pos);
			}
			return removed;

		}

		/**********************************************************************
		 * General helper functions
		 **********************************************************************/
		private boolean less(final Object key1, final Object key2) {
			// TODO
			return this.compare(key1, key2) < 0;
		}

		private int compare(final Object key1, final Object key2) {
			if (this.comparator != null) {
				return this.comparator.compare((Key) key1, (Key) key2);
			}
			Comparable<? super Key> comp1 = (Comparable<? super Key>) key1;
			Comparable<? super Key> comp2 = (Comparable<? super Key>) key2;
			return comp1.compareTo((Key) comp2);
		}

		// swap pq[i] <-> pq[j] and qp[pq[i]] <-> qp[pq[j]]
		private void swap(int i, int j) {
			int index1 = this.pq[i];
			int index2 = this.pq[j];
			int swap = this.pq[i];
			this.pq[i] = this.pq[j];
			this.pq[j] = swap;
			swap = this.qp[index1];
			this.qp[index1] = this.qp[index2];
			this.qp[index2] = swap;
		}

		void log() {
			System.out.println("keys = " + Arrays.toString(keys));
			System.out.println("pq = " + Arrays.toString(pq));
			System.out.println("qp = " + Arrays.toString(qp));
		}

		/**********************************************************************
		 * Iterators
		 **********************************************************************/
		public Iterator<Integer> iterator() {
			return new HeapIterator();
		}

		private class HeapIterator implements Iterator<Integer> {
			private final MinHeap<Key> minHeap;

			public HeapIterator() {
				minHeap = new MinHeap<>(capacity());
				for (int i = 0; i < capacity(); i++) {
					if (contains(i)) {
						minHeap.add(i, keyOf(i));
					}
				}
			}

			@Override
			public boolean hasNext() {
				return !minHeap.isEmpty();
			}

			@Override
			public Integer next() {
				return minHeap.poll();
			}

		}

	}
}
