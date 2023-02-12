package org.leetcode.contests.weekly.w0285;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class B {
	public int countCollisions(String ds) {
		int ans = 0;
		Deque<Character> dq = new ArrayDeque<>();
		for (char cur : ds.toCharArray()) {
			if (cur == 'L') {
				if (!dq.isEmpty() && dq.peekLast() != 'L') {
					if (dq.pollLast() == 'R') {
						ans += 2;
					} else {
						ans++;
					}
					while (!dq.isEmpty() && dq.peekLast() == 'R') {
						ans++;
						dq.pollLast();
					}
					dq.addLast('S');
				} else {
					dq.addLast(cur);
				}

			} else if (cur == 'R') {
				dq.addLast('R');
			} else {
				while (!dq.isEmpty() && dq.peekLast() == 'R') {
					ans++;
					dq.pollLast();
				}
				dq.addLast('S');
			}
		}
		return ans;
	}
}
