package org.leetcode.problems;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000109_ConvertSortedListToBST {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public TreeNode sortedListToBST(ListNode head) {
		return convert(head);
	}

	TreeNode convert(ListNode head) {
		if (head == null)
			return null;
		if (head.next == null)
			return new TreeNode(head.val);
		ListNode slow = head;
		ListNode fast = slow.next.next;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		TreeNode root = new TreeNode(slow.next.val);
		root.right = convert(slow.next.next);
		slow.next = null;
		root.left = convert(head);
		return root;
	}
}
