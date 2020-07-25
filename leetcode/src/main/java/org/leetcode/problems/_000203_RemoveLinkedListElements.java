package org.leetcode.problems;

/**
 * 
 * EASY
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000203_RemoveLinkedListElements {
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public ListNode removeElements(ListNode head, int val) {
		ListNode fake = new ListNode(0);
	        fake.next = head;
	        ListNode cur = fake;
	        while(cur != null) {
	            while(cur.next != null && cur.next.val == val) cur.next = cur.next.next;
	            cur = cur.next;
	        }
	        return fake.next;
	}
}
