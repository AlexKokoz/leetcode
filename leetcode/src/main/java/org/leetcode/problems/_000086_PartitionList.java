package org.leetcode.problems;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000086_PartitionList {
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public ListNode partition(ListNode head, int x) {
		ListNode lessHead = new ListNode(0);
		ListNode lastLess = lessHead;
		ListNode greaterEqualHead = new ListNode(0);
		ListNode lastGreaterEqual = greaterEqualHead;

		ListNode cur = head;
		while (cur != null) {
			if (cur.val < x) {
				lastLess.next = cur;
				lastLess = cur;
				cur = cur.next;
				lastLess.next = null;
			} else {
				lastGreaterEqual.next = cur;
				lastGreaterEqual = cur;
				cur = cur.next;
				lastGreaterEqual.next = null;
			}
		}
		lastLess.next = greaterEqualHead.next;
		return lessHead.next;
	}
}
