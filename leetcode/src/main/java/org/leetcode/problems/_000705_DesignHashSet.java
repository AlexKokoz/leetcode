package org.leetcode.problems;

import java.util.LinkedList;
import java.util.List;

/**
 * 
 * EASY
 * 
 * @author akokozidis
 *
 */
public class _000705_DesignHashSet {
	class MyHashSet {
		final int capacity = 200000;
		final List<Integer>[] buckets;

		/** Initialize your data structure here. */
		@SuppressWarnings("unchecked")
		public MyHashSet() {
			buckets = new List[capacity];
		}

		public void add(int key) {
			int id = hash(key);
			if (buckets[id] == null) {
				buckets[id] = new LinkedList<>();
			}
			for (int i = 0; i < buckets[id].size(); i++)
				if (buckets[id].get(i) == key)
					return;
			buckets[id].add(key);
		}

		public void remove(int key) {
			int id = hash(key);
			if (buckets[id] == null)
				return;
			for (int i = 0; i < buckets[id].size(); i++)
				if (buckets[id].get(i) == key) {
					buckets[id].remove(i);
					return;
				}
		}

		/** Returns true if this set contains the specified element */
		public boolean contains(int key) {
			int id = hash(key);
			if (buckets[id] == null) {
				buckets[id] = new LinkedList<>();
			}
			for (int i = 0; i < buckets[id].size(); i++)
				if (buckets[id].get(i) == key)
					return true;
			return false;
		}

		private int hash(int key) {
			return (key & 0x7fffffff) % capacity;
		}
	}
}
