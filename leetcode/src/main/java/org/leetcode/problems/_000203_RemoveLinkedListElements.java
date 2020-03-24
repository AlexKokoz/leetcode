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
		ListNode last = fake;
		ListNode cur = head;
		while (cur != null) {
			if (cur.val != val) {
				last.next = cur;
				last = cur;
			}
			cur = cur.next;
		}
		last.next = null;
		return fake.next;
	}
}
