package org.leetcode.problems;

/**
 * 
 * EASY
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000234_PalindromeLinkedList {
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public boolean isPalindrome(ListNode head) {
		if (head == null || head.next == null)
			return true;

		ListNode slow = head;
		ListNode fast = head.next.next;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		ListNode right;
		if (fast == null) { // even
			right = slow.next;
		} else { // odd
			right = slow.next.next;
		}

		ListNode left = null;
		ListNode cur = head;
		ListNode stop = slow.next;
		while (cur != stop) {
			ListNode nextCur = cur.next;
			cur.next = left;
			left = cur;
			cur = nextCur;
		}

		while (left != null) {
			if (left.val != right.val)
				return false;
			left = left.next;
			right = right.next;
		}
		return true;
	}
}
