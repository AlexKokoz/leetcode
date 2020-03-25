package org.leetcode.problems;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000817_LinkedListComponents {
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public int numComponents(ListNode head, int[] G) {
		boolean[] marked = new boolean[10000];
		for (int x : G)
			marked[x] = true;
		int nComponents = 0;
		int conseq = 0;
		ListNode cur = head;
		while (cur != null) {
			if (marked[cur.val]) {
				conseq++;
				marked[cur.val] = false;
			} else if (conseq > 0) {
				nComponents++;
				conseq = 0;
			}
			cur = cur.next;
		}
		if (conseq > 0)
			nComponents++;
		return nComponents;
	}
}
