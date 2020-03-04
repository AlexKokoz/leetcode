package org.leetcode.problems;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000002_AddTwoNumbers {
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode root = null;
		ListNode currentNode = null;
		int carry = 0;
		while (l1 != null || l2 != null) {
			int d1 = 0;
			int d2 = 0;
			if (l1 != null) {
				d1 = l1.val;
				l1 = l1.next;
			}
			if (l2 != null) {
				d2 = l2.val;
				l2 = l2.next;
			}
			int curSum = d1 + d2 + carry;
			carry = curSum / 10;
			ListNode newNode = new ListNode(curSum % 10);
			if (root == null) {
				root = newNode;
				currentNode = newNode;
			} else {
				currentNode.next = newNode;
				currentNode = newNode;
			}
		}
		if (carry > 0)
			currentNode.next = new ListNode(carry);
		return root;
	}

}
