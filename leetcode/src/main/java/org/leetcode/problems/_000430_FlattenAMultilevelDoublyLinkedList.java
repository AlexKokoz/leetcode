package org.leetcode.problems;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000430_FlattenAMultilevelDoublyLinkedList {
	class Node {
		public int val;
		public Node prev;
		public Node next;
		public Node child;
	}

	public Node flatten(Node head) {
		return head == null ? null : helper1(head)[0];
	}

	Node[] helper1(Node node) {
		if (node == null)
			return null;
		Node[] ret = new Node[2];
		ret[0] = node;
		Node cur = node;
		Node prev = null;
		while (cur != null) {
			Node next = cur.next;
			prev = cur;
			Node[] ch = helper1(cur.child);
			if (ch != null) {
				cur.child = null;
				cur.next = ch[0];
				ch[0].prev = cur;
				ch[1].next = next;
				prev = ch[1];
				if (next != null) {
					next.prev = ch[1];
				}
			}
			cur = next;
		}
		ret[1] = prev;
		return ret;
	}
}
