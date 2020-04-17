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
		ListNode fake = new ListNode(0);
		fake.next = swap(head);
		return fake.next;
	}

	ListNode swap(ListNode node) {
		if (node == null || node.next == null)
			return node;
		ListNode first = node.next;
		ListNode second = node;
		ListNode rest = node.next.next;
		first.next = second;
		second.next = swap(rest);
		return first;
	}

}
