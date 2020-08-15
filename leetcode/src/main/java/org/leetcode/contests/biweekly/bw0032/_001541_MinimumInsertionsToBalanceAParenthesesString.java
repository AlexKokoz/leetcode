package org.leetcode.contests.biweekly.bw0032;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001541_MinimumInsertionsToBalanceAParenthesesString {
	public int minInsertions(String s) {
		int n = s.length();
		List<Integer> list = new ArrayList<>();
		int ans = 0;
		int l = 0;
		while (l < n) {
			int r = l + 1;
			while (r < n && s.charAt(l) == s.charAt(r))
				r++;
			if (s.charAt(l) == '(')
				list.add((r - l) * 2);
			else {
				int d = r - l;
				if ((d & 1) == 1) {
					d++;
					ans++;
				}
				list.add(-d);
			}
			l = r;
		}
		int sum = 0;
		for (int x : list) {
			sum += x;
			if (sum < 0) {
				ans -= sum / 2;
				sum = 0;
			}
		}
		ans += sum;
		return ans;
	}
}
