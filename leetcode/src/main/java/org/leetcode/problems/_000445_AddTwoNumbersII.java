package org.leetcode.problems;

import java.util.Stack;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000445_AddTwoNumbersII {
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		Stack<Integer> st1 = collect(l1);
		Stack<Integer> st2 = collect(l2);
		return buildList(st1, st2);
	}

	Stack<Integer> collect(ListNode node) {
		Stack<Integer> stack = new Stack<>();
		ListNode cur = node;
		while (cur != null) {
			stack.add(cur.val);
			cur = cur.next;
		}
		return stack;
	}

	ListNode buildList(Stack<Integer> st1, Stack<Integer> st2) {
		ListNode last = null;
		int carry = 0;
		while (!st1.isEmpty() || !st2.isEmpty() || carry > 0) {
			int d1 = st1.isEmpty() ? 0 : st1.pop();
			int d2 = st2.isEmpty() ? 0 : st2.pop();
			int sum = d1 + d2 + carry;
			ListNode node = new ListNode(sum % 10);
			node.next = last;
			last = node;
			carry = sum / 10;
		}
		return last;
	}
}
