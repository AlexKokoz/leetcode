package org.leetcode.problems;

import java.util.Stack;

/**
 * MEDIUM
 * 
 * @author akokozidis
 *
 */
public class _000147_InsertionSortList {
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public ListNode insertionSortList(ListNode head) {
		if (head == null)
			return null;
		Stack<ListNode> stackFront = new Stack<>();
		Stack<ListNode> stackBack = new Stack<>();
		ListNode cur = head;
		while (cur != null) {
			ListNode next = cur.next;
			while (!stackFront.isEmpty() && stackFront.peek().val > cur.val) {
				stackBack.add(stackFront.pop());
			}
			if (!stackFront.isEmpty())
				stackFront.peek().next = cur;
			if (!stackBack.isEmpty())
				cur.next = stackBack.peek();
			stackFront.add(cur);
			while (!stackBack.isEmpty())
				stackFront.add(stackBack.pop());
			stackFront.peek().next = null;
			cur = next;
		}
		while (!stackFront.isEmpty())
			cur = stackFront.pop();
		return cur;
	}
}
