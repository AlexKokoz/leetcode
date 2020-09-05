package org.leetcode.contests.biweekly.bw0033;

/**
 * 
 * EASY
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001556_ThousandSeparator {
	public String thousandSeparator(int n) {
		StringBuilder sb = new StringBuilder(n + "");
		StringBuilder ans = new StringBuilder();
		for (int i = sb.length() - 1, step = 0; i >= 0; i--, step++) {
			if (step == 3)
				step = 0;
			if (step == 0 && i < sb.length() - 1)
				ans.append('.');
			ans.append(sb.charAt(i));
		}
		return sb.reverse().toString();
	}
}
