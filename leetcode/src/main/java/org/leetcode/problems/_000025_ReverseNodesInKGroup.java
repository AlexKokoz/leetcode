package org.leetcode.problems;

/**
 * 
 * HARD
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000025_ReverseNodesInKGroup {
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public ListNode reverseKGroup(ListNode head, int k) {
		ListNode fake = new ListNode(0);
		ListNode left = fake;
		ListNode right = fake;

		fake.next = head;
		while (right.next != null) {
			for (int i = 0; i < k && right != null; i++)
				right = right.next;
			if (right == null)
				break;
			ListNode cur = left.next;
			ListNode next = right.next;
			ListNode nextLeft = left.next;
			while (cur != right) { // todo
				left.next = cur.next;
				cur.next = next;
				next = cur;
				cur = left.next;
				right.next = next;
			}
			left = nextLeft;
			right = left;
		}
		return fake.next;
	}
}
