package org.leetcode.problems;

import java.util.*;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001019_NextGreaterNodeInLinkedList {
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public int[] nextLargerNodes(ListNode head) {
		Queue<Integer> q = new LinkedList<>();
		ListNode cur = head;
		while (cur != null) {
			q.add(cur.val);
			cur = cur.next;
		}
		List<Integer> list = new LinkedList<>(q);
		int[] ans = new int[q.size()];
		Stack<Integer> stack = new Stack<>();
		for (int i = ans.length - 1; i >= 0; i--) {
			int val = list.get(i);
			while (!stack.isEmpty() && stack.peek() <= val)
				stack.pop();
			if (!stack.isEmpty())
				ans[i] = stack.peek();
			stack.add(val);
		}
		return ans;
	}
}
