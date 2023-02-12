package org.leetcode.contests.weekly.w0289;

import java.util.Arrays;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class B {
	public int minimumRounds(int[] tasks) {
		Arrays.sort(tasks);
		int n = tasks.length;
		int ans = 0;
		for (int l = 0; l < n;) {
			int r = l;
			while (r < n && tasks[r] == tasks[l]) {
				r++;
			}
			int count = r - l;
			if (count == 1)
				return -1;
			int mod = count % 3;
			if (mod == 0) {
				ans += count / 3;
			} else {
				ans += count / 3 + 1;
			}
			l = r;
		}
		return ans;
	}
}
