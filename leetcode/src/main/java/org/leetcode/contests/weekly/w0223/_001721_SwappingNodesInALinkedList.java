package org.leetcode.contests.weekly.w0223;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001721_SwappingNodesInALinkedList {

	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public ListNode swapNodes(ListNode head, int k) {
		List<Integer> list = new ArrayList<>();

		for (ListNode cur = head; cur != null; cur = cur.next) {
			list.add(cur.val);
		}
		int i = k - 1;
		int j = list.size() - k;
		if (i == j)
			return head;
		swap(i, j, list);
		ListNode cur = head;
		for (int x = 0; x < list.size(); x++) {
			cur.val = list.get(x);
			cur = cur.next;
		}
		return head;
	}

	void swap(int i, int j, List<Integer> list) {
		int temp = list.get(i);
		list.set(i, list.get(j));
		list.set(j, temp);
	}
}
