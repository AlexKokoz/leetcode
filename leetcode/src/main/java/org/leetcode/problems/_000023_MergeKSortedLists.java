package org.leetcode.problems;

import java.util.*;

/**
 * 
 * HARD
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000023_MergeKSortedLists {
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public ListNode mergeKLists(ListNode[] lists) {
		ListNode fake = new ListNode(0);
		ListNode last = fake;
		PriorityQueue<ListNode> pq = new PriorityQueue<>(new Comparator<ListNode>() {
			public int compare(ListNode a, ListNode b) {
				if (a.val < b.val)
					return -1;
				if (a.val > b.val)
					return 1;
				return 0;
			}
		});
		for (ListNode node : lists)
			if (node != null)
				pq.add(node);
		while (!pq.isEmpty()) {
			ListNode cur = pq.poll();
			if (cur.next != null)
				pq.add(cur.next);
			last.next = cur;
			last = last.next;
		}
		return fake.next;
	}
}
