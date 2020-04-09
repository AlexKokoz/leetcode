package org.leetcode.problems;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000024_SwapNodesInPairs {

	static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public ListNode swapPairs(ListNode head) {
		return swap(head);
	}

	static ListNode swap(ListNode cur) {
		if (cur == null)
			return null;
		ListNode newNode = null;
		if (cur.next != null) {
			newNode = new ListNode(cur.next.val);
			newNode.next = new ListNode(cur.val);
			newNode.next.next = swap(cur.next.next);
		} else {
			newNode = new ListNode(cur.val);
		}
		return newNode;
	}

}
