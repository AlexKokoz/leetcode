package org.leetcode.problems;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 30-day Leetcoding Challenge 2020
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000000_FirstUniqueNumber {
	class FirstUnique {

		Set<Integer> values;
		Map<Integer, ListNode> nodes;
		ListNode headBorder;
		ListNode tailBorder;
		int size;

		public FirstUnique(int[] nums) {
			values = new HashSet<>();
			nodes = new HashMap<>();
			headBorder = new ListNode(0);
			tailBorder = new ListNode(0);
			headBorder.next = tailBorder;
			tailBorder.prev = headBorder;
			for (int num : nums)
				add(num);
		}

		public int showFirstUnique() {
			return size == 0 ? -1 : headBorder.next.value;
		}

		public void add(int value) {
			if (values.contains(value)) {
				if (nodes.containsKey(value)) {
					ListNode toBeRemoved = nodes.remove(value);
					ListNode prev = toBeRemoved.prev;
					ListNode next = toBeRemoved.next;
					prev.next = next;
					next.prev = prev;
					size--;
				}
			} else {
				values.add(value);
				ListNode newNode = new ListNode(value);
				nodes.put(value, newNode);
				ListNode prev = tailBorder.prev;
				ListNode next = tailBorder;
				newNode.prev = prev;
				prev.next = newNode;
				newNode.next = next;
				next.prev = newNode;
				size++;
			}
		}

		class ListNode {
			private int value;
			private ListNode prev;
			private ListNode next;

			public ListNode(int value) {
				this.value = value;
			}
		}
	}
}
