package org.leetcode.problems;

/**
 * 
 * EASY
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000206_ReverseLinkedList {
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public ListNode reverseList(ListNode head) {
		return reverse(head, null);
	}

	ListNode reverse(ListNode head, ListNode tail) {
		if (head == null)
			return tail;
		ListNode newTail = head;
		head = head.next;
		newTail.next = tail;
		return reverse(head, newTail);
	}
}
