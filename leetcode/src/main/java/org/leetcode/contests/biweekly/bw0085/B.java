package org.leetcode.contests.biweekly.bw0085;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class B {
	public int secondsToRemoveOccurrences(String s) {
		int n = s.length();
		int ans = 0;
		boolean changed = true;
		char[] cs = s.toCharArray();
		while (changed) {
			changed = false;
			for (int i = n - 1; i > 0; i--) {
				if (cs[i] == '1' && cs[i - 1] == '0') {
					cs[i - 1] = '1';
					cs[i] = '0';
					i--;
					changed = true;
				}

			}
			if (changed)
				ans++;
		}

		return ans;
	}
}
