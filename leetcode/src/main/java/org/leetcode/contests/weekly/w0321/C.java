package org.leetcode.contests.weekly.w0321;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class C {

	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public ListNode removeNodes(ListNode head) {
		if (head == null)
			return null;
		ListNode fake = new ListNode(0);
		List<Integer> vals = new ArrayList<>();
		ListNode cur = head;
		while (cur != null) {
			vals.add(cur.val);
			cur = cur.next;
		}
		int[] maxRL = new int[vals.size() + 1];
		maxRL[maxRL.length - 1] = Integer.MIN_VALUE;
		for (int i = vals.size() - 1; i >= 0; i--) {
			maxRL[i] = Math.max(maxRL[i + 1], vals.get(i));
		}
		System.out.println(Arrays.toString(maxRL));
		cur = head;
		ListNode par = fake;
		for (int i = 0; i < vals.size(); i++) {
			ListNode ncur = cur.next;
			// System.out.println(i + " " + cur.val + " " + maxRL[i + 1]);
			if (cur.val >= maxRL[i + 1]) {
				par.next = cur;
				par = par.next;
				par.next = null;
			}
			cur = ncur;
		}

		return fake.next;
	}
}
