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
		ListNode oddHead = head;
		ListNode evenHead = (head != null ? head.next : null);
		ListNode oddTail = oddHead;
		ListNode evenTail = evenHead;
		ListNode cur = (evenHead != null ? evenHead.next : null);
		if (oddHead != null)
			oddHead.next = null;
		if (evenHead != null)
			evenHead.next = null;
		boolean odd = true;
		while (cur != null) {
			if (odd) {
				oddTail.next = cur;
				oddTail = oddTail.next;

			} else {
				evenTail.next = cur;
				evenTail = evenTail.next;

			}
			odd = !odd;
			cur = cur.next;
			oddTail.next = null;
			evenTail.next = null;
		}
		if (oddTail != null)
			oddTail.next = evenHead;
		return oddHead;
	}

	// Editorial Solution :'(
//	public ListNode oddEvenList(ListNode head) {
//		if (head == null)
//			return null;
//		ListNode odd = head, even = head.next, evenHead = even;
//		while (even != null && even.next != null) {
//			odd.next = even.next;
//			odd = odd.next;
//			even.next = odd.next;
//			even = even.next;
//		}
//		odd.next = evenHead;
//		return head;
//	}
}
