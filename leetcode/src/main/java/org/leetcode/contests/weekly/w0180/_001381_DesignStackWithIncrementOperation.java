package org.leetcode.contests.weekly.w0180;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001381_DesignStackWithIncrementOperation {
	class CustomStack {
		int[] st;
		int head;

		public CustomStack(int maxSize) {
			head = 0;
			st = new int[maxSize];
		}

		public void push(int x) {
			if(head < st.length)
				st[head++] = x;
		}

		public int pop() {
			return head == 0 ? -1 : st[--head];
		}

		public void increment(int k, int val) {
			k = Math.min(k, head);
			for (int i = 0; i < k; i++) {
				st[i] += val;
			}
		}
	}
}
