package org.leetcode.problems;

/**
 * EASY
 * 
 * @author AccelSprinter
 *
 */
public class _000141_LinkedListCycle {

	class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public boolean hasCycle(ListNode head) {
		if (head == null)
			return false;
		return findCollisionNode(head) != null;
	}

	ListNode findCollisionNode(ListNode head) {
		if (head == null) {
			return null;
		}
		ListNode slow = head;
		ListNode fast = head;
		while (fast != null) {
			slow = slow.next;
			fast = fast.next;
			if (fast == null) {
				break;
			}
			fast = fast.next;
			if (slow == fast) {
				return slow;
			}
		}
		return null;
	}

}
