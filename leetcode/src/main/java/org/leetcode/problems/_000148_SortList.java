package org.leetcode.problems;

import java.util.LinkedList;
import java.util.Queue;

/**
 * MEDIUM
 * 
 * @author akokozidis
 *
 */
public class _000148_SortList {
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public ListNode sortList(ListNode head) {
		return quickSortList(head);
	}

	Queue<ListNode> q;

	ListNode quickSortList(ListNode node) {
		if (node == null)
			return null;
		q = new LinkedList<>();
		while (node != null) {
			ListNode next = node.next;
			node.next = null;
			q.add(node);
			node = next;
		}
		while (q.size() > 1) {
			ListNode a = q.poll();
			ListNode b = q.poll();
			q.add(merge(a, b));
		}
		return q.poll();
	}

	ListNode merge(ListNode a, ListNode b) {
		ListNode merged = null, last = null;
		while (a != null && b != null) {
			ListNode less = null;
			if (a.val < b.val) {
				less = a;
				a = a.next;
			} else {
				less = b;
				b = b.next;
			}
			if (merged == null)
				merged = last = less;
			else {
				last.next = less;
				last = last.next;
			}
		}
		while (a != null) {
			last.next = a;
			last = last.next;
			a = a.next;
		}
		while (b != null) {
			last.next = b;
			last = last.next;
			b = b.next;
		}
		return merged;
	}
}
