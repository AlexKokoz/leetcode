package org.leetcode.contests.biweekly.bw0040;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001669_MergeInBetweenLinkedLists {
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
		ListNode fake = new ListNode(0);
		fake.next = list1;
		// find ath, bth
		ListNode cur = fake;
		ListNode beforeA = null;
		ListNode afterB = null;
		for (int i = -1;; i++) {
			if (i + 1 == a) {
				beforeA = cur;
			}
			if (i == b) {
				afterB = cur.next;
				break;
			}
			cur = cur.next;
		}
		// find tail of list2
		ListNode tail2 = list2;
		while(tail2.next != null) tail2 = tail2.next;
		beforeA.next = list2;
		tail2.next = afterB;
		return fake.next;
	}
}
