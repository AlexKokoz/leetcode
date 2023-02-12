package org.leetcode.contests.weekly.w0236;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Iterator;
import java.util.TreeMap;

/**
 * 
 * HARD
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001825_FindingMKAverage {
	class MKAverage {
		MultiTreeSet<Integer> left, middle, right;
		int[] arr;
		int m, k, total, mMinus2K, p;
		long leftSum, middleSum, rightSum;
		Deque<Integer> history;

		public MKAverage(int m, int k) {
			history = new ArrayDeque<>();
			left = new MultiTreeSet<>();
			middle = new MultiTreeSet<>();
			right = new MultiTreeSet<>();
			arr = new int[m];
			this.m = m;
			this.k = k;
			mMinus2K = m - 2 * k;
		}

		public void addElement(int num) {
			history.add(num);
			if (total < m) {
				arr[p++] = num;
				total++;
				if (total == m) {
					Arrays.sort(arr);
					for (int i = 0; i < k; i++) {
						left.add(arr[i]);
						leftSum += arr[i];
					}
					for (int i = k; i < k + mMinus2K; i++) {
						middle.add(arr[i]);
						middleSum += arr[i];
					}
					for (int i = k + mMinus2K; i < m; i++) {
						right.add(arr[i]);
						rightSum += arr[i];
					}
				}

			} else {
				int removed = history.pollFirst();

				// remove excess element
				if (left.contains(removed)) {
					left.remove(removed);
					leftSum -= removed;
				} else if (middle.contains(removed)) {
					middle.remove(removed);
					middleSum -= removed;
				} else { // right.contains(removed)
					right.remove(removed);
					rightSum -= removed;
				}

				// add new element
				if ((left.size() > 0 && num <= left.last())
						|| (middle.size() > 0 && num <= middle.first())) {
					left.add(num);
					leftSum += num;
				} else if ((middle.size() > 0 && num <= middle.last())
						|| (right.size() > 0 && num <= right.first())) {
					middle.add(num);
					middleSum += num;
				} else {
					right.add(num);
					rightSum += num;
				}

				if (left.actualSize() > k) {
					if (right.actualSize() < k) {

						// left -> middle
						int leftLast = left.last();
						middle.add(leftLast);
						middleSum += leftLast;
						left.remove(leftLast);
						leftSum -= leftLast;

						// middle -> right
						int middleLast = middle.last();
						right.add(middleLast);
						rightSum += middleLast;
						middle.remove(middleLast);
						middleSum -= middleLast;

					} else {
						// left -> middle
						int leftLast = left.last();
						middle.add(leftLast);
						middleSum += leftLast;
						left.remove(leftLast);
						leftSum -= leftLast;
					}
				} else if (middle.actualSize() > mMinus2K) {
					if (left.actualSize() < right.actualSize()) {
						int middleFirst = middle.first();
						left.add(middleFirst);
						leftSum += middleFirst;
						middle.remove(middleFirst);
						middleSum -= middleFirst;
					} else {
						int middleLast = middle.last();
						right.add(middleLast);
						rightSum += middleLast;
						middle.remove(middleLast);
						middleSum -= middleLast;
					}

				} else if (right.actualSize() > k) {
					if (left.actualSize() < k) {
						// middle <- right
						int rightFirst = right.first();
						middle.add(rightFirst);
						middleSum += rightFirst;
						right.remove(rightFirst);
						rightSum -= rightFirst;

						// left <- middle
						int middleFirst = middle.first();
						left.add(middleFirst);
						leftSum += middleFirst;
						middle.remove(middleFirst);
						middleSum -= middleFirst;
					} else {
						int rightFirst = right.first();
						middle.add(rightFirst);
						middleSum += rightFirst;
						right.remove(rightFirst);
						rightSum -= rightFirst;
					}
				}

				total++;
			}

		}

		public int calculateMKAverage() {
			return total < m ? -1 : (int) (middleSum / mMinus2K);
		}

		class MultiTreeSet<K> implements Iterable<K> {
			private final TreeMap<K, Long> map;
			private long actualSize;

			public MultiTreeSet() {
				this.map = new TreeMap<>();
			}

			public boolean contains(final K key) {
				return map.containsKey(key);
			}

			public void add(final K key) {
				map.put(key, map.getOrDefault(key, 0L) + 1);
				actualSize++;
			}

			public void add(final K key, final long times) {
				map.put(key, map.getOrDefault(key, 0L) + times);
				actualSize += times;
			}

			/**
			 * Removes one occurrence of the specified key, if it exists. If no more
			 * occurrences of this key remain right after the operation, the key is deleted
			 * from the multi-set.
			 * 
			 * @param key the key
			 * @return true if the specified key had at least one occurrence prior the
			 *         operation; false otherwise
			 */
			public void remove(final K key) {
				final Long count = map.get(key);

				// key doesn't exist in map
				if (count == null) {
					return;
				}
				// key has only one occurrence
				else if (count == 1) {
					map.remove(key);
					actualSize--;
				}
				// key had more than one occurrence
				else {
					map.put(key, count - 1);
					actualSize--;
				}
			}

			/**
			 * Removes all occurrences of the key by effectively deleting the key
			 * 
			 * @param key the key
			 */
			public void removeAll(final K key) {
				final Long count = map.get(key);

				if (count != null) {
					actualSize -= count;
					map.remove(key);
				}
			}

			/**
			 * Removes {@code times} occurrences of key {@code key}. If {@code key} doesn't
			 * exist, nothing happens. If {@code times} >= {@code key}'s frequency, then the
			 * key is deleted.
			 * 
			 * @param key   the key
			 * @param times the number of occurrences of key to be deleted
			 */
			public void remove(final K key, final long times) {
				final Long count = map.get(key);
				if (count != null) {
					long ncount = Math.max(0, count - times);
					if (ncount == 0)
						removeAll(key);
					else {
						map.put(key, ncount);
						actualSize -= count - ncount;
					}
				}
			}

			// number of distinct keys
			public int size() {
				return map.size();
			}

			// frequency of {@Code key}
			public Long count(final K key) {
				return map.get(key);
			}

			// sum of all key frequencies
			public long actualSize() {
				return actualSize;
			}

			public K ceiling(final K key) {
				return map.ceilingKey(key);
			}

			public K floor(final K key) {
				return map.floorKey(key);
			}

			public K lower(final K key) {
				return map.lowerKey(key);
			}

			public K higher(final K key) {
				return map.higherKey(key);
			}

			public K first() {
				return map.isEmpty() ? null : map.firstKey();
			}

			public K last() {
				return map.isEmpty() ? null : map.lastKey();
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
	}
}
