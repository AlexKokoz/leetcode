package org.leetcode.contests.weekly.w0281;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class B {
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public ListNode mergeNodes(ListNode head) {
		ListNode fake = new ListNode(0);
		ListNode par = fake;
		while (true) {
			int sum = 0;
			ListNode nhead = head.next;
			if (nhead == null)
				break;
			while (nhead.val != 0) {
				sum += nhead.val;
				nhead = nhead.next;
			}
			par.next = new ListNode(sum);
			head = nhead;
			par = par.next;
		}
		return fake.next;
	}
}
