package org.leetcode.problems;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000707_DesignLinkedList {
	static class MyLinkedList {

		private Node head;
		private Node tail;
		private int size;

		/**
		 * Returns true if the list is empty; false otherwise.
		 * 
		 * @return true if the list is empty; false otherwise
		 */
		public boolean isEmpty() {
			return head == null;
		}

		/** Initialize your data structure here. */
		public MyLinkedList() {

		}

		/**
		 * Get the value of the index-th node in the linked list. If the index is
		 * invalid, return -1.
		 */
		public int get(int index) {
			Node node = getNode(index);
			return node != null ? node.val : -1;
		}

		private Node getNode(int index) {
			if (index < 0 || index >= size)
				return null;
			int mid = size / 2;
			if (index < mid)
				return searchNodeFromHead(index);
			else
				return searchNodeFromTail(index);
		}

		private Node searchNodeFromHead(int index) {
			Node cur = head;
			for (int i = 0; i < index; i++)
				cur = cur.next;
			return cur;
		}

		private Node searchNodeFromTail(int index) {
			Node cur = tail;
			for (int i = size - 1; i > index; i--)
				cur = cur.prev;
			return cur;
		}

		/**
		 * Add a node of value val before the first element of the linked list. After
		 * the insertion, the new node will be the first node of the linked list.
		 */
		public void addAtHead(int val) {
			final Node newNode = new Node(val);
			if (isEmpty()) {
				head = newNode;
				tail = newNode;
			} else {
				head.prev = newNode;
				newNode.next = head;
				head = newNode;
			}
			size++;
		}

		/** Append a node of value val to the last element of the linked list. */
		public void addAtTail(int val) {
			System.out.println("tail: " + val);
			final Node newNode = new Node(val);
			if (isEmpty()) {
				head = newNode;
				tail = newNode;
			} else {
				tail.next = newNode;
				newNode.prev = tail;
				tail = newNode;
			}
			size++;
		}

		/**
		 * Add a node of value val before the index-th node in the linked list. If index
		 * equals to the length of linked list, the node will be appended to the end of
		 * linked list. If index is greater than the length, the node will not be
		 * inserted.
		 */
		public void addAtIndex(int index, int val) {
			if (index < 0 || index > size)
				return;
			else if (index == 0)
				addAtHead(val);
			else if (index == size)
				addAtTail(val);
			else {
				Node next = getNode(index);
				Node prev = next.prev;
				Node newNode = new Node(val);
				newNode.prev = prev;
				newNode.next = next;
				prev.next = newNode;
				next.prev = newNode;
				size++;
			}
		}

		/** Delete the index-th node in the linked list, if the index is valid. */
		public void deleteAtIndex(int index) {
			Node toDelete = getNode(index);
			if (toDelete == null)
				return;
			Node prev = toDelete.prev;
			Node next = toDelete.next;
			size--;
			if (size == 0) {
				head = null;
				tail = null;
			} else {
				if (prev == null)
					head = next;
				else
					prev.next = next;
				if (next == null)
					tail = null;
				else
					next.prev = prev;
			}
		}

		void log() {
			Node cur = head;
			while (cur != null) {
				System.out.print(cur.val + " ");
				cur = cur.next;
			}
			System.out.println();
		}

		// ================================================================================
		// PRIVATE CLASSES
		// ================================================================================

		private static class Node {
			final int val;
			Node prev, next;

			public Node(int val) {
				this.val = val;
			}
		}
	}
}
