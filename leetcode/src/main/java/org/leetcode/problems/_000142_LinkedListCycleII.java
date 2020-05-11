package org.leetcode.problems;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000142_LinkedListCycleII {

	class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public ListNode detectCycle(ListNode head) {
		if (head == null)
			return null;
		ListNode collision = findCollisionNode(head);
		if (collision == null)
			return null;
		ListNode intersection = findIntersectionNode(head, collision);
		return intersection;
	}

	static ListNode findCollisionNode(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;
		while (fast != null) {
			slow = slow.next;
			fast = fast.next;
			if (fast == null)
				return null;
			fast = fast.next;
			if (slow == fast)
				return slow;
		}
		return null;
	}
	
	static ListNode findIntersectionNode(ListNode head, ListNode collision) {
		ListNode pointer1 = head;
		ListNode pointer2 = collision;
		while(pointer1 != pointer2) {
			pointer1 = pointer1.next;
			pointer2 = pointer2.next;
		}
		return pointer1;
	}
}
