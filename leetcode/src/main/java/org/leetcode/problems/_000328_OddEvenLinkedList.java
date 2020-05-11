package org.leetcode.problems;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000328_OddEvenLinkedList {

	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public ListNode oddEvenList(ListNode head) {
		ListNode fakeOddsHead = new ListNode(0);
		ListNode fakeEvensHead = new ListNode(0);
		ListNode lastOdd = fakeOddsHead;
		ListNode lastEven = fakeEvensHead;
		ListNode cur = head;
		for (int i = 1; cur != null; i++) {
			if (i % 2 == 1) {
				lastOdd.next = cur;
				lastOdd = cur;
				cur = cur.next;
				lastOdd.next = null;
			} else {
				lastEven.next = cur;
				lastEven = cur;
				cur = cur.next;
				lastEven.next = null;
			}
		}
		lastOdd.next = fakeEvensHead.next;
		return fakeOddsHead.next;
	}

}
