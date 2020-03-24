package org.leetcode.problems;

/**
 * 
 * EASY
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000237_DeleteNodeInALinkedList {
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public void deleteNode(ListNode node) {
		ListNode cur = node;
		ListNode next = cur.next;
		while (true) {
			cur.val = next.val;
			if (next.next == null)
				break;
			cur = next;
			next = next.next;
		}
		cur.next = null;
	}
}
