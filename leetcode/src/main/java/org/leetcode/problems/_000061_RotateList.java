package org.leetcode.problems;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000061_RotateList {
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public ListNode rotateRight(ListNode head, int k) {
		if (head == null || head.next == null)
			return head;
		int len = len(head);
		k = k % len;
		if (k == 0) return head;
		ListNode slow = head;
		ListNode fast = head;
		for (int i = 0; i < k; i++) {
			fast = fast.next;
		}
		while (fast.next != null) {
			slow = slow.next;
			fast = fast.next;
		}
		fast.next = head;
		head = slow.next;
		slow.next = null;
		return head;
	}

	int len(ListNode head) {
		ListNode cur = head;
		int len = 0;
		while (cur != null) {
			len++;
			cur = cur.next;
		}
		return len;
	}
}
