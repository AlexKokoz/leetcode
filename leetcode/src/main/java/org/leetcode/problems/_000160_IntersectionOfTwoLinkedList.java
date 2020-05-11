package org.leetcode.problems;

/**
 * 
 * EASY
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000160_IntersectionOfTwoLinkedList {

	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		int lenA = len(headA);
		int lenB = len(headB);

		int diff = Math.abs(lenA - lenB);

		ListNode l = null, s = null;

		if (lenA >= lenB) {
			l = headA;
			s = headB;
		} else {
			l = headB;
			s = headA;
		}

		for (int k = 0; k < diff; k++)
			l = l.next;
		while (l != null) {
			if (l == s)
				return l;
			l = l.next;
			s = s.next;
		}
		return null;
	}

	static int len(ListNode node) {
		if (node == null)
			return 0;
		return 1 + len(node.next);
	}

}
