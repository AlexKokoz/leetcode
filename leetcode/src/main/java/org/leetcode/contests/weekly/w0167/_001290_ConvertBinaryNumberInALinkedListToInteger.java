package org.leetcode.contests.weekly.w0167;

/**
 * EASY
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001290_ConvertBinaryNumberInALinkedListToInteger {
	static class ListNode {
		int val;
		ListNode next;

		public ListNode(int val) {
			this.val = val;
		}
	}

	public int getDecimalValue(ListNode head) {
		final StringBuilder sb = new StringBuilder();

		while (head != null) {
			sb.append(head.val);
			head = head.next;
		}
		return Integer.parseInt(sb.toString(), 2);
	}

}
