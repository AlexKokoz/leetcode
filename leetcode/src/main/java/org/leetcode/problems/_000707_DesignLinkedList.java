package org.leetcode.problems;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000707_DesignLinkedList {
	class MyLinkedList {
		private final ListNode fakeHead;
		private final ListNode fakeTail;
		private int size;

		public MyLinkedList() {
			fakeHead = new ListNode(0);
			fakeTail = new ListNode(0);
			fakeHead.next = fakeTail;
			fakeTail.prev = fakeHead;
		}

		public boolean isEmpty() {
			return size == 0;
		}

		public int get(int index) {
			if (index < 0 || index >= size) {
				return -1;
			} else {
				return getNode(index).value;
			}
		}

		public void addAtHead(int value) {
			final ListNode newNode = new ListNode(value);
			final ListNode nextNode = fakeHead.next;
			newNode.prev = fakeHead;
			fakeHead.next = newNode;
			newNode.next = nextNode;
			nextNode.prev = newNode;
			size++;
		}

		public void addAtTail(int value) {
			final ListNode newNode = new ListNode(value);
			final ListNode prevNode = fakeTail.prev;
			newNode.prev = prevNode;
			prevNode.next = newNode;
			newNode.next = fakeTail;
			fakeTail.prev = newNode;
			size++;
		}

		private ListNode getNode(int index) {
			assert 0 <= index && index < size;
			int mid = size >>> 1;
			if (index < mid) {
				return searchNodeFromHead(index);
			} else {
				return searchNodeFromTail(index);
			}
		}

		public void addAtIndex(int index, int value) {
			if (index < 0 || index > size) {
				return;
			} else if (index == 0) {
				addAtHead(value);
			} else if (index == size) {
				addAtTail(value);
			} else {
				final ListNode prevNode = getNode(index - 1);
				final ListNode nextNode = prevNode.next;
				final ListNode newNode = new ListNode(value);
				newNode.prev = prevNode;
				prevNode.next = newNode;
				newNode.next = nextNode;
				nextNode.prev = newNode;
				size++;
			}
		}

		public void deleteAtIndex(int index) {
			if (index < 0 || index >= size) {
				return;
			} else {
				final ListNode targetNode = getNode(index);
				final ListNode prevNode = targetNode.prev;
				final ListNode nextNode = targetNode.next;
				prevNode.next = nextNode;
				nextNode.prev = prevNode;
				size--;
			}
		}

		private ListNode searchNodeFromHead(int index) {
			assert 0 <= index && index < size;
			ListNode cur = fakeHead.next;
			for (int i = 0; i < index; i++) {
				cur = cur.next;
			}
			return cur;
		}

		private ListNode searchNodeFromTail(int index) {
			assert 0 <= index && index < size;
			ListNode cur = fakeTail.prev;
			for (int i = size - 1; i > index; i--) {
				cur = cur.prev;
			}
			return cur;
		}

		private class ListNode {
			private final int value;
			private ListNode prev;
			private ListNode next;

			public ListNode(int setValue) {
				this.value = setValue;
			}
		}
	}
}
