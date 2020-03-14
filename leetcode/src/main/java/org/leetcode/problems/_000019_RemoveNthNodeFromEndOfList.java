package org.leetcode.problems;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000019_RemoveNthNodeFromEndOfList {
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode fake = new ListNode(0);
		fake.next = head;
		ListNode fast = fake;
		ListNode slow = fake;
		for (int i = 0; i < n; i++)
			fast = fast.next;
		while (fast.next != null) {
			slow = slow.next;
			fast = fast.next;
		}
		slow.next = slow.next.next;
		return fake.next;
	}
}
