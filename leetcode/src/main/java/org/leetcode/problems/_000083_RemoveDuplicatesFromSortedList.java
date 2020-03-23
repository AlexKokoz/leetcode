package org.leetcode.problems;

/**
 * 
 * EASY
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000083_RemoveDuplicatesFromSortedList {
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public ListNode deleteDuplicates(ListNode head) {
		if (head == null) return null;
		ListNode slow = head;
		ListNode fast = head.next;
		while(fast != null) {
			if (slow.val == fast.val) {
				fast = fast.next;
				slow.next = fast;
			} else {
				slow = slow.next;
				fast = fast.next;
			}
		}
		return head;
	}
}
