package org.leetcode.problems;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000082_RemoveDuplicatesFromSortedList {
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public ListNode deleteDuplicates(ListNode head) {
		if (head == null)
			return null;
		ListNode fake = new ListNode(0);
		fake.next = head;
		ListNode prev = fake;
		ListNode cur = head;
		while (cur.next != null) {
			if (cur.val == cur.next.val) {
				int val = cur.val;
				while (cur != null && cur.val == val)
					cur = cur.next;
				if (cur == null) break;
			} else { // cur != null && (cur.next == null || cur.val != cur.next.val)) {
				prev.next = cur;
				prev = cur;
				cur = cur.next;
			}
		}
		prev.next = cur;
		return fake.next;
	}
}
