package org.leetcode.contests.biweekly.bw0042;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 
 * EASY
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001700_NumberOfStudentsUnableToEatLunch {
	public int countStudents(int[] students, int[] sandwiches) {
		Queue<Integer> q = new LinkedList<>();
		for (int student : students) {
			q.add(student);
		}
		Stack<Integer> stack = new Stack<>();
		for (int i = sandwiches.length - 1; i >= 0; i--)
			stack.push(sandwiches[i]);
		while (true) {
			boolean changed = false;
			for (int i = 0; i < q.size(); i++) {
				if (q.peek() == stack.peek()) {
					q.poll();
					stack.pop();
					changed = true;
				} else {
					q.add(q.poll());
				}
			}
			if (!changed)
				break;
		}
		return q.size();
	}

}
