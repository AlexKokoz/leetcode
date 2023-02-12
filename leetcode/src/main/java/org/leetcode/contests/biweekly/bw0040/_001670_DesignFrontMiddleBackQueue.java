package org.leetcode.contests.biweekly.bw0040;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001670_DesignFrontMiddleBackQueue {
	class FrontMiddleBackQueue {
		Deque<Integer> dql, dqr;

		public FrontMiddleBackQueue() {
			dql = new ArrayDeque<>();
			dqr = new ArrayDeque<>(); // will hold the middle element, when odd size
		}

		public void pushFront(int val) {
			dql.addFirst(val);
			if (dql.size() > dqr.size())
				dqr.addFirst(dql.pollLast());
		}

		public void pushMiddle(int val) {
			dql.addLast(val);
			if (dql.size() > dqr.size())
				dqr.addFirst(dql.pollLast());
		}

		public void pushBack(int val) {
			dqr.addLast(val);
			if (dql.size() + 1 < dqr.size())
				dql.addLast(dqr.pollFirst());
		}

		public int popFront() {
			if (dql.isEmpty() && dqr.isEmpty())
				return -1;
			if (dql.isEmpty())
				return dqr.pollFirst();
			int ret = dql.pollFirst();
			if (dql.size() + 1 < dqr.size())
				dql.addLast(dqr.pollFirst());
			return ret;
		}

		public int popMiddle() {
			if (dql.isEmpty() && dqr.isEmpty())
				return -1;
			if (dql.size() == dqr.size()) {
				return dql.pollLast();
			} else {
				return dqr.pollFirst();
			}
		}

		public int popBack() {
			if (dql.isEmpty() && dqr.isEmpty())
				return -1;
			int ret = dqr.pollLast();
			if (dql.size() > dqr.size())
				dqr.addFirst(dql.pollLast());
			return ret;
		}
	}
}
