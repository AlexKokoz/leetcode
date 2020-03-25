package org.leetcode.problems;

import java.util.*;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000725_SplitLinkedListInParts {
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public ListNode[] splitListToParts(ListNode root, int k) {
		int len = len(root);
		int[] sizes = new int[k];
		Arrays.fill(sizes, len / k);
		for (int i = 0; i < len % k; i++)
			sizes[i]++;
		ListNode[] ans = new ListNode[k];
		ans[0] = root;
		ListNode cur = root;
		for (int i = 1; i < k; i++) {
			if (cur == null) {
				ans[i] = null;
				continue;
			}
			for (int j = 1; j < sizes[i - 1]; j++)
				cur = cur.next;
			ans[i] = cur.next;
			cur.next = null;
			cur = ans[i];
		}
		return ans;
	}

	int len(ListNode root) {
		int len = 0;
		ListNode cur = root;
		while (cur != null) {
			len++;
			cur = cur.next;
		}
		return len;
	}
}
