package org.leetcode.problems;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000092_ReverseLinkedListII {
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public ListNode reverseBetween(ListNode head, int m, int n) {
		if (m == n)
			return head;
		ListNode fake = new ListNode(0);
		fake.next = head;
		ListNode prev = fake;
		for (int i = 0; i < m - 1; i++)
			prev = prev.next;
		ListNode next = prev.next;
		ListNode start = null;
		ListNode end = next;
		for (int i = 0; i < n - m + 1; i++) {
			ListNode tempNext = next.next;
			next.next = start;
			start = next;
			next = tempNext;
		}
		prev.next = start;
		end.next = next;
		return fake.next;
	}
}
