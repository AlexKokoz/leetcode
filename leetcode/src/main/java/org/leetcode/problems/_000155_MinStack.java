package org.leetcode.problems;

import java.util.Stack;

/**
 * EASY
 * 
 * @author AccelSprinter
 *
 */
public class _000155_MinStack {

	class MinStack {

		Stack<Integer> min;
		Stack<Integer> stack;

		/** initialize your data structure here. */
		public MinStack() {
			min = new Stack<>();
			stack = new Stack<>();
		}

		public void push(int x) {
			stack.push(x);
			min.push(Math.min(x, min.isEmpty() ? x : min.peek()));
		}

		public void pop() {
			if (!stack.isEmpty()) {
				stack.pop();
				min.pop();
			}
		}

		public int top() {
			return stack.peek();
		}

		public int getMin() {
			return min.peek();
		}
	}

}
