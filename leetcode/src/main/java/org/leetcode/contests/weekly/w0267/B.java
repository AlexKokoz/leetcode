package org.leetcode.contests.weekly.w0267;

import java.util.ArrayDeque;
import java.util.Deque;

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

	public ListNode reverseEvenLengthGroups(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode par = head;
		for (int len = 2; par.next != null; len++) {
			ListNode cur = par.next;
			Deque<ListNode> dq = new ArrayDeque<>();
			for (int i = 0; i < len && cur != null; i++) {
				dq.add(cur);
				cur = cur.next;
			}
			ListNode next = dq.peekLast().next;
			if (dq.size() % 2 == 1) {
				while (!dq.isEmpty()) {
					par.next = dq.poll();
					par = par.next;
				}
			} else {
				while (!dq.isEmpty()) {
					par.next = dq.pollLast();
					par = par.next;
				}
			}
			par.next = next;
		}
		return head;
	}
}
