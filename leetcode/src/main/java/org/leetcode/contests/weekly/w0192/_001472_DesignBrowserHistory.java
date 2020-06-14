package org.leetcode.contests.weekly.w0192;

import java.util.*;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001472_DesignBrowserHistory {
	class BrowserHistory {
		List<String> history;
		int cur;
		int end;

		public BrowserHistory(String homepage) {
			history = new ArrayList<>();
			history.add(homepage);
			cur = 0;
			end = 1;
		}

		public void visit(String url) {
			history.add(++cur, url);
			end = cur + 1;
		}

		public String back(int steps) {
			if (steps > cur)
				cur = 0;
			else
				cur -= steps;
			return history.get(cur);
		}

		public String forward(int steps) {
			if (cur + steps >= end)
				cur = end - 1;
			else
				cur += steps;
			return history.get(cur);
		}
	}
}
