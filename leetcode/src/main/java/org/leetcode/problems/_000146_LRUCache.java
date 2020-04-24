package org.leetcode.problems;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000146_LRUCache {
	static class LRUCache {

		private final Map<Integer, Integer> values; // stores key-value pairs to be inserted in LRU cache
		private final Map<Integer, ListNode> nodes; // stores key-doubly_linked_list_node pairs
		private ListNode toLRU; // dummy node that points to LRU node
		private ListNode MRU; // current MRU node
		private int maxCapacity; // the capacity the LRU cache is initialized with

		public LRUCache(int capacity) {
			values = new HashMap<>();
			nodes = new HashMap<>();
			this.maxCapacity = capacity;
			toLRU = new ListNode(0);
			MRU = toLRU;
		}

		public int get(int key) {
			// key doesn't exist
			if (!values.containsKey(key))
				return -1;
			// set key as MRU, if it already wasn't; otherwise just return the value
			if (MRU.value != key) {
				ListNode newMRU = nodes.get(key);
				ListNode prev = newMRU.prev;
				ListNode next = newMRU.next;
				prev.next = next;
				next.prev = prev;
				MRU.next = newMRU;
				newMRU.prev = MRU;
				newMRU.next = null;
				MRU = newMRU;
			}
			return values.get(key);
		}

		public void put(int key, int value) {

			// key exists
			if (values.containsKey(key)) {
				// update its value
				values.put(key, value);
				// set key as MRU; this is the same as get() but without returning its value
				get(key);
			}
			// key doesn't exist
			else {
				// store key-value pair and add as MRU
				values.put(key, value);
				ListNode newMRU = new ListNode(key);
				nodes.put(key, newMRU);
				MRU.next = newMRU;
				newMRU.prev = MRU;
				MRU = newMRU;
				// capacity overflow: remove LRU node its key-value pair
				if (values.size() > maxCapacity) {
					int LRU = toLRU.next.value;
					toLRU.next = toLRU.next.next;
					toLRU.next.prev = toLRU;
					values.remove(LRU);
					nodes.remove(LRU);
				}
			}

		}

		// doubly linked list node; it corresponds to a key existing in the LRU cache;
		// if the key is deleted, so is its node
		class ListNode {
			int value;
			ListNode next;
			ListNode prev;

			public ListNode(int value) {
				this.value = value;
			}
		}
	}
}
