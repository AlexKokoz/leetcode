package org.leetcode.problems;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001251_SequentialDigits {
	public List<Integer> sequentialDigits(int low, int high) {
		List<Integer> ans = new ArrayList<>();
		String lo = Integer.toString(low);

		StringBuilder sb = new StringBuilder("123456789");
		int l = 0;
		int r = lo.length() - 1;
		int len = r - l + 1;
		while (true) {
			if (r >= 9) {
				l = 0;
				r = l + len;
				len++;
			}
			if (len > 9)
				break;
			int cand = Integer.parseInt(sb.substring(l, r + 1));
			if (cand > high)
				break;
			if (cand >= low)
				ans.add(cand);
			l++;
			r++;
		}
		return ans;
	}
}
