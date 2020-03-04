package org.leetcode.problems;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001367_LinkedListInBinaryTree {

	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public boolean isSubPath(ListNode head, TreeNode root) {
		if (head == null)
			return true;
		if (root == null)
			return false;
		boolean cur = check(head, root);
		return cur || isSubPath(head, root.left) || isSubPath(head, root.right);
	}

	boolean check(ListNode listnode, TreeNode treenode) {
		if (listnode == null)
			return true;
		if (treenode == null)
			return false;
		if (listnode.val != treenode.val)
			return false;
		return check(listnode.next, treenode.left) || check(listnode.next, treenode.right);
	}

}
