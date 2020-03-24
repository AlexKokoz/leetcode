package org.leetcode.problems;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000143_ReorderList {
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public void reorderList(ListNode head) {
		if (head == null || head.next == null || head.next.next == null)
			return;
		
		// find middle element, stored at slow
		ListNode slow = head;
		ListNode fast = head.next;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		ListNode right = slow.next;

		// reverse nodes from head to middle, store them at left; right part of the linked list is stored at right
		ListNode left = null;
		ListNode cur = head;
		while (cur != right) {
			ListNode nextCur = cur.next;
			cur.next = left;
			left = cur;
			cur = nextCur;
		}

		// if linked list size is even last element is first from right, otherwise first from left
		ListNode last;
		if (fast != null) { // even
			ListNode newLeft = left.next;
			ListNode newRight = right.next;
			left.next = right;
			right.next = null;
			last = left;
			left = newLeft;
			right = newRight;
		} else {
			last = left;
			left = left.next;
			last.next = null;
		}
		
		// prepend in alternating order to last node, first from right then from left
		while (left != null) {
			ListNode newLeft = left.next;
			ListNode newRight = right.next;
			right.next = last;
			left.next = right;
			last = left;
			left = newLeft;
			right = newRight;
		}

	}
}
