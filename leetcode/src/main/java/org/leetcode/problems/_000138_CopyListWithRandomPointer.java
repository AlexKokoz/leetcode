package org.leetcode.problems;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000138_CopyListWithRandomPointer {
	class Node {
		int val;
		Node next;
		Node random;

		public Node(int val) {
			this.val = val;
			this.next = null;
			this.random = null;
		}
	}

	public Node copyRandomList(Node head) {
		Map<Node, Node> original2copy = new HashMap<>();
		Node fake = new Node(0);
		Node last = fake;
		Node cur = head;
		while (cur != null) {
			Node copy = original2copy.getOrDefault(cur, new Node(cur.val));
			last.next = copy;
			last = copy;
			original2copy.put(cur, copy);
			if (cur.random != null) {
				Node randomCopy = original2copy.getOrDefault(cur.random, new Node(cur.random.val));
				copy.random = randomCopy;
				original2copy.put(cur.random, randomCopy);
			}
			cur = cur.next;
		}
		return fake.next;
	}
}
