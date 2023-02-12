package org.leetcode.contests.biweekly.bw0069;

import java.util.ArrayList;
import java.util.List;

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

	public int pairSum(ListNode head) {
		List<ListNode> nodes = new ArrayList<>();
		while (head != null) {
			nodes.add(head);
			head = head.next;
		}
		int ans = 0;
		int n = nodes.size();
		for (int i = 0; i < n / 2; i++) {
			ans = Math.max(ans, nodes.get(i).val + nodes.get(n - 1 - i).val);
		}
		return ans;
	}
}
