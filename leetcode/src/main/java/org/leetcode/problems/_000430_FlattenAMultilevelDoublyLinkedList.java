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
		getLastChild(head);
		return head;
	}

	Node getLastChild(Node cur) {
		Node prev = null;
		while (cur != null) {
			if (cur.child != null) {
				Node lastChild = getLastChild(cur.child);
				cur.child.prev = cur;
				Node next = cur.next;
				cur.next = cur.child;
				cur.child = null;
				lastChild.next = next;
				if (next != null) {
					prev = lastChild;
					next.prev = lastChild;
					cur = next;
				} else {
					prev = lastChild;
					cur = lastChild;
				}
			} else {
				prev = cur;
				cur = cur.next;
			}
		}
		return prev;
	}
}
